package com.example.agromind.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class FertilizerTools {

    @Tool(name = "estimate_fertilizer_plan", description = "Estimate a basic fertilizer plan from crop, field area and soil nutrient level. The result is educational and must be adjusted by soil testing and local agronomists.")
    public FertilizerPlan estimateFertilizerPlan(
            @ToolParam(description = "Crop name, for example wheat, corn, tomato, rice") String crop,
            @ToolParam(description = "Field area in mu, Chinese area unit") Double areaMu,
            @ToolParam(description = "Soil fertility level: low, medium, high") String fertilityLevel
    ) {
        double area = areaMu == null || areaMu <= 0 ? 1.0 : areaMu;
        String fertility = fertilityLevel == null ? "medium" : fertilityLevel.toLowerCase();

        double baseN = switch (fertility) {
            case "low" -> 12.0;
            case "high" -> 6.0;
            default -> 9.0;
        };
        double baseP2O5 = switch (fertility) {
            case "low" -> 6.0;
            case "high" -> 3.0;
            default -> 4.5;
        };
        double baseK2O = switch (fertility) {
            case "low" -> 8.0;
            case "high" -> 4.0;
            default -> 6.0;
        };

        return new FertilizerPlan(
                crop == null || crop.isBlank() ? "通用作物" : crop,
                area,
                fertility,
                round(baseN * area),
                round(baseP2O5 * area),
                round(baseK2O * area),
                "这是教学估算值。实际施肥必须结合测土配方、目标产量、前茬、灌溉条件和当地肥料登记标签。"
        );
    }

    private double round(double value) {
        return Math.round(value * 10.0) / 10.0;
    }

    public record FertilizerPlan(
            String crop,
            double areaMu,
            String fertilityLevel,
            double nitrogenKg,
            double phosphorusP2O5Kg,
            double potassiumK2OKg,
            String safetyNote
    ) {
    }
}
