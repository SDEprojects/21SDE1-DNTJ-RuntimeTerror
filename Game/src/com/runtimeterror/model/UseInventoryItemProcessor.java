package com.runtimeterror.model;

import com.runtimeterror.textparser.InputData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseInventoryItemProcessor {
    public static String useItem(InputData parsedInput,Player player, HashMap<String, Rooms> roomList){
        String result = "";
        if (player.hasItem(parsedInput.getNoun())) {
            if ("bolt cutters".equals(parsedInput.getNoun())) {
                if ("Main Hall".equals(player.getCurrRoom().getRoomName())) {
                    roomList.get("Main Hall").setRoomDescription("This is the main hall.  The chains blocking your escape have been broken.  There are stairs leading up.");
                    // ToDo:  add exit room to the main hall to the west.
                    result = "You place the blades of the bolt cutters around a link of the chain and close your eyes.  With all you might, you squeeze the cutter's handles.  You feel the rusty handle of the cutters snap.  You feel that all hope is lost but out of the corner of your eye you see the chain is broken.";
                } else {
                    result = "You look around but don't see anything that bolt cutters would help with.";
                }
            }
            // ToDo:  add other item logic below... just follow the bolt cutter logic above...
        }
        else {
            result = "You don't have " + parsedInput.getNoun();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static void useItem2(Map<String, Result<?>> gameMap){
        InputData inputData = (InputData)  gameMap.get("inputData").getResult();
        Rooms room = (Rooms) gameMap.get("playerCurrentRoom").getResult();
        String noun = inputData.getNoun();
        List<Item> inventory = (List<Item>) gameMap.get("inventory").getResult();
        Item itemToRemove = new Item();
        for (Item item : inventory) {
            if(item != null && noun.equals(item.getName())) {
                gameMap.put("usedItem", new Result<>(true));
                gameMap.put("itemUsed", new Result<>(noun));
                itemToRemove = item;
                break;
            } else {
                gameMap.put("usedItem", new Result<>(false));
            }
        }
        inventory.remove(itemToRemove);
    }
}
