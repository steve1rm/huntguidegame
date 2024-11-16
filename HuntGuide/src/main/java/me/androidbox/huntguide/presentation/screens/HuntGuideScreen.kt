package me.androidbox.huntguide.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import me.androidbox.huntguide.R
import me.androidbox.huntguide.presentation.models.HuntGuideModel
import me.androidbox.huntguide.presentation.screens.components.HuntGuideItemPager

@Composable
fun HuntGuideScreen(
    onCloseClicked: () -> Unit
) {
    val huntGuideItems = remember {
        populateItems()
    }

    HuntGuideItemPager(
        modifier = Modifier.background(color = Color.Black),
        items = huntGuideItems,
        content = { huntGuideItem ->
            HuntGuideItemPage(
                title = huntGuideItem.title,
                subTitle = huntGuideItem.subTitle,
                body = huntGuideItem.body,
                image = huntGuideItem.res
            )
        },
        onCloseClicked = onCloseClicked
    )
}


fun populateItems(): List<HuntGuideModel> {
    return listOf(
        HuntGuideModel(
            title = "01 MASTER YOURLOADOUT",
            subTitle = "Choose the Perfect Weapon Combo",
            body = "In your inventory you will be able to select your loadout by picking the two weapons you’ll rely on during the hunt. Each gun has unique strengths, so choose a combo that best matches your play style for maximum impact.",
            res = R.drawable.one
        ),
        HuntGuideModel(
            title = "02 elixir",
            subTitle = "your energy source and lifeline",
            body = "On Planet-X, everything you use is powered by elixir and you start each hunt with a full tank. This means your weapons, your scanner, your shield, anything with a power source relies on it.\n" +
                    "Since elixir is limited in each hunt, plan your usage carefully to get the most out of every action, giving yourself the best possible chance to win.",
            res = R.drawable.two
        ),
        HuntGuideModel(
            title = "03 elixir refill stations",
            subTitle = "top up your tank",
            body = "During a hunt, elixir refill stations are situated around the map. Use these to top up your elixir stores if you’re running low. However beware, other players will be looking to do the same thing so these are dangerous spots to visit!",
            res = R.drawable.three
        ),
        HuntGuideModel(
            title = "04 elixir vials",
            subTitle = "quick refill on the move",
            body = "You'll have the ability to take three elixir vials into each hunt if you have them in your inventory.  Vials can be bought in the store, stolen of other players or won in loot boxes. These allow you to quickly top up your elixir without having to go to a refill station. Perfect lifesavers for high-stakes moments like shootouts or prize scans. Use them strategically!",
            res = R.drawable.four
        ),
        HuntGuideModel(
            title = "05 activating your minimap",
            subTitle = "find an omni cell",
            body = "To unlock your mini-map you will have to Activate a Omni Cell situated on Planet-X. Omni cells shoot a distinct blue beam into the sky, which can be seen to try and locate them. Once your mini-map is activated you will be able to see key information such as other players carrying prizes, where chests have been found, how to find an extraction point and much more!\n",
            res = R.drawable.five
        ),
        HuntGuideModel(
            title = "06 scanning for chests",
            subTitle = "win prizes",
            body = "Your scanner allows you to find the hidden chests on Planet-X. Simply turn on your scanner and start running around to try and find one. If you find a chest you will be alerted as it pops out the ground. Then open the chest and pick up the prize.",
            res = R.drawable.six
        ),
        HuntGuideModel(
            title = "07 yellow and red chests",
            subTitle = "common and rare chests",
            body = "Your scanner allows you to find the hidden chests on Planet-X. Simply turn on your scanner and start running around to try and find one. If you find a chest you will be alerted as it pops out the ground. Then open the chest and pick up the prize.",
            res = R.drawable.seven
        ),
        HuntGuideModel(
            title = "08 extract a prize",
            subTitle = "become an official winner",
            body = "If you happen to find a prize; you will need to extract it using an extraction rocket found on the mini-map to become an official winner. \n" +
                    "Extraction rockets are dangerous areas as you could come across campers trying to steal your prize.\n" +
                    "If you manage to successfully make it to the rocket, you will then need to input a 4 digit code which will appear on your screen for the extraction to be successful. \n",
            res = R.drawable.eight
        ),
        HuntGuideModel(
            title = "09 using your shield",
            subTitle = "master your defence",
            body = "Turning on your shield protects you from incoming fire whilst using elixir. This sheild however can be broken if it takes too much damage. If it does get broken, you’ll face a brief cooldown before being able to reactivate it, so time your defenses carefully!\n",
            res = R.drawable.nine
        ),
        HuntGuideModel(
            title = "10 using your drone",
            subTitle = "scout ahead tactically",
            body = "Use your drone situated under your mini-map to help you scout for nearby enemies or ensures areas of the map are clear, such as the extraction rocket. You can also use it to lock on to enemy players, which then gives you the ability to hunt them down or see if they’re holding a prize at anytime. Since it consumes elixir, use it strategically to maximize your advantage without depleting your resources.\n",
            res = R.drawable.ten
        ),
        HuntGuideModel(
            title = "11 stealing prizes",
            subTitle = "hunt down other players",
            body = "When another player finds a prize, they will appear as a marked man on the mini-map for a few seconds, giving away their position. They will also have a visible pin above their head the entire time, showing other players they have a prize.\n" +
                    "\n" +
                    "Kill them and pick up their loot, to steal prizes. \n" +
                    "\n",
            res = R.drawable.eleven
        ),
        HuntGuideModel(
            title = "12 marked man indicators ",
            subTitle = "MArked man:\n yellow & red",
            body = "If an emery player is carrying X-tokens they will have a yellow icon above their head.\n" +
                    "\n" +
                    "If an enemy player is carrying a more valuable loot, an instant prize win, they will have a red pin above their head. \n" +
                    "\n" +
                    "Use these indicators to know decide whether you want to engage in a fight or not.",
            res = R.drawable.twelve
        )
    )
}
