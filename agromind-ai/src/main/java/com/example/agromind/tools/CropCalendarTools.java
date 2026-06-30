package com.example.agromind.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CropCalendarTools {

    @Tool(name = "get_crop_calendar", description = "Generate a simple crop management calendar for a crop and growth stage.")
    public CropCalendar getCropCalendar(
            @ToolParam(description = "Crop name, for example wheat, corn, tomato, rice") String crop,
            @ToolParam(description = "Growth stage, for example seedling, flowering, fruiting, jointing, harvest") String growthStage
    ) {
        String normalizedCrop = crop == null || crop.isBlank() ? "通用作物" : crop;
        String stage = growthStage == null || growthStage.isBlank() ? "当前生长期" : growthStage;

        return new CropCalendar(
                normalizedCrop,
                stage,
                List.of(
                        "巡田：每2-3天检查叶片、茎基部、根系和土壤墒情。",
                        "水分：避免长期积水；设施棚室注意通风降湿。",
                        "营养：根据长势少量多次追肥，避免一次性过量。",
                        "病虫害：优先农业防治和物理防治，化学防治必须按标签和当地法规执行。",
                        "记录：记录天气、灌溉、施肥、用药和症状变化，方便复盘。"
                )
        );
    }

    public record CropCalendar(String crop, String growthStage, List<String> tasks) {
    }
}
