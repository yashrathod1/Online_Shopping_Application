package com.example.EliteShop.myclass;

import android.content.Context;

import com.example.EliteShop.HomeDatabase;
import com.example.EliteShop.ItemClass;
import com.example.EliteShop.R;

import java.util.ArrayList;

public class LoadData {

    public LoadData(Context context){
        ArrayList<ItemClass> homeArrayList = new ArrayList<>();

        int itemCartColor = R.color.cart_image_red;
        homeArrayList.add(new ItemClass("iPhone 15 (Blue, 128 GB)","RAM | ROM \n Processor A16 Bionic Chip, 6 Core Processor | Hexa Core \n Front Camera\n48MP + 12MP\n Front Camera\n12MP\nDisplay\n6.1 inch All Screen OLED Display",
                79900,R.drawable.iphone15, itemCartColor,0));

        homeArrayList.add(new ItemClass("APPLE AirPods Pro","APPLE AirPods Pro (2nd generation) with Active Noise Cancellation, Spatial Audio Bluetooth Headset  (White, True Wireless)",
                24990,R.drawable.earbard, itemCartColor,0));

        homeArrayList.add(new ItemClass("Sony TV Bravia", " Bravia LED-backlit LCD High-definition television Smart TV 1080p, sony, television", 99999,
                R.drawable.sony_tv, itemCartColor,0));

        homeArrayList.add(new ItemClass("Air Conditioner","Air conditioning Air door Daikin Furnace Air conditioner, Finlux,",60000,R.drawable.airconditioner, itemCartColor,0));

        homeArrayList.add(new ItemClass("MacBook AIR M2","APPLE 2022 MacBook AIR M2 - (8 GB/256 GB SSD/Mac OS Monterey) MLY13HN/A  (13.6 Inch, Starlight, 1.24 kg)",97990,R.drawable.macbook, itemCartColor,0));

        homeArrayList.add(new ItemClass("Samsung Refrigerator","SAMSUNG 314 L Frost Free Double Door 2 Star Convertible Refrigerator with with Curd Maestro (LUXE BLACK, RT34A4622BX/HL)",33000,R.drawable.fridge, itemCartColor,0));

        homeArrayList.add(new ItemClass("Home Delight 138 LEDs","Home Delight 138 LEDs 2.49 m Yellow Rice Lights  (Pack of 1)",425,R.drawable.home_light, itemCartColor,0));

        homeArrayList.add(new ItemClass("Philips Hometheater","Philips Audio MMS-4545B 2.1 Channel Speakers System (Black)",5000,R.drawable.hometheater, itemCartColor,0));

        homeArrayList.add(new ItemClass("Apple Smartwatch","Clairbell XSQ_735F A1_4G smart watch Smartwatch  (Black Strap, XL)",1200,R.drawable.smartwatch, itemCartColor,0));

        homeArrayList.add(new ItemClass("Haier Washing Machine","Haier 10.5 Kg 5 star Fully Automatic Front Load Washing Dryer HWD105-B14959S8U1, Dark Jade Silver,2024, Super Drum 525, Washer Dryer, Puri Steam)",50000,R.drawable.washingmachine, itemCartColor,0));

        HomeDatabase homeDatabase = new HomeDatabase( context);
        for (int i = 0; i < homeArrayList.size(); i++) {
            ItemClass itemClass = homeArrayList.get(i);
            homeDatabase.addData(itemClass.itemName,itemClass.itemDisc, itemClass.price,itemClass.image,itemClass.itemCartColor,itemClass.isCart);
        }
    }
}
