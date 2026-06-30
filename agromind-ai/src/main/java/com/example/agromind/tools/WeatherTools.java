package com.example.agromind.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class WeatherTools {

    @Tool(name = "get_field_weather", description = "Get demo weather and field environment information for a crop field. This is mock data and should be replaced by a real weather API in production.")
    public FieldWeather getFieldWeather(
            @ToolParam(description = "Region or city name, for example 山东寿光 or 河南周口") String region,
            @ToolParam(description = "Crop name, for example tomato, wheat, corn, rice") String crop
    ) {
        String normalizedRegion = region == null || region.isBlank() ? "示例地区" : region;
        String normalizedCrop = crop == null || crop.isBlank() ? "未知作物" : crop;
        return new FieldWeather(
                normalizedRegion,
                normalizedCrop,
                LocalDate.now().toString(),
                28.5,
                21.0,
                72,
                6.5,
                "未来24小时湿度偏高，注意通风、排水和叶面病害巡查；生产环境请接入真实天气 API。"
        );
    }

    public record FieldWeather(
            String region,
            String crop,
            String date,
            double highTemperatureCelsius,
            double lowTemperatureCelsius,
            int humidityPercent,
            double windSpeedMps,
            String advisory
    ) {
    }
}
