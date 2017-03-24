var GAME_LEVELS = [
    {
        "level": "1",
        "scoreGoal": "2500",
        "scoreStars": "1000, 2000, 2500",
        "colors": "0124",
        "layouts": "50, 25, 5, 0",
        "hintText": "tutorial.basics",
        "hintIcon": "ProfessorNormal",
        "layout": "???????????????????????????????????????????????????????????????????????????????????111???????111????"
    },
    {
        "level": "2",
        "scoreGoal": "3000",
        "scoreStars": "1000, 2000, 3000",
        "colors": "01234",
        "layouts": "50, 50, 0, 0",
        "hintText": "tutorial.cookie",
        "hintIcon": "ProfessorNormal",
        "specials": "C:1x1",
        "specialsRandom": "yes",
        "specialsMax": "7",
        "layout": "???????????????????????????????????????????2>1>???????**????????12????????12???????1>2>??????114>???"
    },
    {
        "level": "3",
        "cookieGoal": "12",
        "scoreStars": "1000,  3000, 5000",
        "movesLimit": "20",
        "colors": "0134",
        "layouts": "50, 10, 0, 0",
        "hintText": "tutorial.moves",
        "hintIcon": "ProfessorScared",
        "layout": "????44????????**????????13????????**???????3313??????4**4??????4134?????31**13???*3*11*3*?0000000100"
    },
    {
        "level": "4",
        "cookieGoal": "5",
        "scoreStars": "1000, 5000, 12000",
        "movesLimit": "50",
        "colors": "0123",
        "layouts": "50, 5, 5, 0",
        "hintText": "tutorial.bomb",
        "hintIcon": "ProfessorHappy",
        "bonuses": "bomb",
        "specials": "C:2x1",
        "specialsRandom": "yes",
        "specialsMax": "2",
        "layout": "??????????????????????????????112????233221????322211????332211020233221*>02*>3221102023322110020332"
    },
    {
        "level": "5",
        "collectFruits": "yes",
        "scoreStars": "1000, 3000, 5000",
        "movesLimit": "30",
        "colors": "01234",
        "layouts": "50, 10, 0, 1",
        "hintText": "tutorial.fruits",
        "hintIcon": "ProfessorHappy",
        "bonuses": "bomb",
        "layoutFruitCount": "25",
        "layout": "????????????????????????33????????33????????33????????13??????313131????122223????32G>21????12..23??"
    },
    {
        "level": "6",
        "collectFruits": "yes",
        "scoreStars": "1000, 5000, 10000",
        "movesLimit": "75",
        "colors": "01234",
        "layouts": "70, 20, 1, 1",
        "bonuses": "bomb",
        "layoutFruitCount": "10, 20",
        "layout": "????????????????????????????????????????????????????????????????Y>????????*>????????G>????????..????"
    },
    {
        "level": "7",
        "cookieGoal": "10",
        "scoreStars": "1000, 7000, 15000",
        "movesLimit": "50",
        "colors": "1234",
        "layouts": "50, 0, 2, 0",
        "bonuses": "bomb",
        "specials": "C:1x2",
        "specialsRandom": "yes",
        "specialsMax": "4",
        "layout": "?????????????????????????????????????????????????????????????????????????****??????....??????1234???"
    },
    {
        "level": "8",
        "cookieGoal": "5",
        "scoreStars": "1000, 5000, 10000",
        "movesLimit": "50",
        "colors": "01234",
        "layouts": "50, 10, 0, 0",
        "bonuses": "bomb",
        "layout": "??????????????????????????????11????????11????????11????????11????????11????????*>*>*>*>*>0123401234"
    },
    {
        "level": "9",
        "collectFruits": "yes",
        "scoreStars": "1000, 5000, 10000",
        "movesLimit": "50",
        "colors": "01234",
        "layouts": "50, 10, 0, 1",
        "bonuses": "bomb",
        "layoutFruitCount": "20, 20, 20",
        "layout": "?????????????????????????????????1100??????1100??????1100??????1100???*??*10*??*2G>2G>2G>23..3..3..3"
    },
    {
        "level": "10",
        "cookieGoal": "25",
        "scoreStars": "1000, 15000, 20000",
        "movesLimit": "45",
        "colors": "0124",
        "layouts": "50, 50, 0, 0",
        "bonuses": "bomb",
        "layout": "?????????*????????*0???4444*1*???444*2*0??444*1*1*2224*2*2*0112*1*1*1*24*2*2*2*02*4*1*1*1*2242424240"
    },
    {
        "level": "11",
        "collectFruits": "yes",
        "scoreStars": "4000, 8000, 12000",
        "movesLimit": "15",
        "colors": "0123",
        "layouts": "70, 1, 5, 1",
        "bonuses": "extraMoves",
        "layoutFruitCount": "5, 5, 5, 5",
        "hintText": "tutorial.frozen",
        "hintIcon": "ProfessorNormal",
        "layout": "???P??G??????0000???1>?1313?1>?3>13131>???130013????300001????100003????310031????131313????0G31P0??"
    },
    {
        "level": "12",
        "scoreGoal": "5000",
        "scoreStars": "2000, 3000, 5000",
        "movesLimit": "25",
        "colors": "0123",
        "layouts": "50, 0, 0, 25",
        "bonuses": "extraMoves",
        "layout": "????????????????????????????????????????????12????????21????????12???????2..1?????1.30.2???1.3030.1?"
    },
    {
        "level": "13",
        "cookieGoal": "7",
        "scoreStars": "4000, 8000, 12000",
        "movesLimit": "20",
        "colors": "0123",
        "layouts": "100, 0, 0, 0",
        "bonuses": "extraMoves",
        "specials": "C:1x2",
        "specialsRandom": "yes",
        "specialsMax": "4",
        "layout": "???????????????????????????????????????????*??*??????.??.??????0??0?????*>?0*>???1..?3..1?001003011?"
    },
    {
        "level": "14",
        "collectFruits": "yes",
        "scoreStars": "2500, 5000, 7000",
        "movesLimit": "35",
        "colors": "01234",
        "layouts": "70, 0, 0, 0",
        "bonuses": "extraMoves",
        "layoutFruitCount": "5, 5, 5, 5, 5",
        "layout": "?????????????????????????????????3??3???2>?3??3?2>?1>3??31>???0>??0>?????P??P??????4G>4?????Y>..Y>??"
    },
    {
        "level": "15",
        "collectFruits": "yes",
        "scoreStars": "2500, 5000, 7000",
        "movesLimit": "20",
        "colors": "0423",
        "layouts": "50, 0, 25, 0",
        "bonuses": "extraMoves",
        "layoutFruitCount": "9, 9, 9",
        "layout": "????????????????????????????????????????????????????????????????44????????44??????4>Y>3>????44GP33??"
    },
    {
        "level": "16",
        "collectFruits": "yes",
        "scoreStars": "4000, 8000, 12000",
        "movesLimit": "30",
        "colors": "01234",
        "layouts": "200, 0, 0, 1",
        "bonuses": "extraMoves",
        "layoutFruitCount": "15, 15, 9, 9",
        "layout": "??????????????????????????????????????????????????????44????????44???????2Y>2??????2G>2????33P..P33?"
    },
    {
        "level": "17",
        "scoreStars": "4000, 8000, 12000",
        "cookieGoal": "10",
        "movesLimit": "50",
        "colors": "01234",
        "layouts": "50, 0, 0, 0",
        "bonuses": "extraMoves",
        "specials": "C:1x1",
        "specialsRandom": "yes",
        "specialsMax": "5",
        "layout": "?????????????????????????????????????????????????????????????????????????3??4???*0*2**2*0*1102342011"
    },
    {
        "level": "18",
        "scoreGoal": "9000",
        "scoreStars": "5000, 9000, 15000",
        "movesLimit": "15",
        "colors": "01234",
        "layouts": "100, 20, 0, 0",
        "bonuses": "extraMoves",
        "layout": "????????????????????????????????????????????????????????????????????????????????????????????????????"
    },
    {
        "level": "19",
        "scoreStars": "3000, 6000, 9000",
        "cookieGoal": "4",
        "movesLimit": "30",
        "colors": "01234",
        "layouts": "50, 2, 2, 0",
        "bonuses": "extraMoves",
        "layout": "???****??????....??????2340??????1234??????0123??????4012??????3401??????2340??????1234??????0123???"
    },
    {
        "level": "20",
        "scoreGoal": "15000",
        "scoreStars": "5000, 15000, 17000",
        "movesLimit": "25",
        "colors": "0123",
        "layouts": "50, 10, 10, 5",
        "bonuses": "extraMoves",
        "layout": "??????????????????????????????33??????33330>3>0>3322......2222.1>2>.2201......0101..0>..0101......01"
    },
    {
        "level": "21",
        "scoreStars": "5000, 10000, 15000",
        "cookieGoal": "10",
        "movesLimit": "45",
        "colors": "0123",
        "layouts": "50, 0, 0, 1",
        "bonuses": "columnClear",
        "layout": "0????????20????????20????????20>??????2>..??????..00??????2200??????2200??????22**********0123012301"
    },
    {
        "level": "22",
        "scoreStars": "5000, 10000, 15000",
        "cookieGoal": "10",
        "movesLimit": "45",
        "colors": "1234",
        "layouts": "100, 0, 2, 0",
        "bonuses": "rowClear",
        "layout": "*>??????*>0????????0*>??????*>0????????0*>??????*>0????????0*>??????*>0????????0*>??????*>0????????0"
    },
    {
        "level": "23",
        "scoreStars": "7000, 12000, 17000",
        "scoreGoal": "15000",
        "movesLimit": "30",
        "colors": "01234",
        "layouts": "100, 2, 2, 2",
        "bonuses": "rowClear, columnClear, bomb",
        "layout": "??????????????????????????????????00????????00???????1001?????112211???11222211?11222222111222222221"
    },
    {
        "level": "24",
        "scoreStars": "5000, 10000, 12000",
        "cookieGoal": "7",
        "movesLimit": "65",
        "colors": "01234",
        "layouts": "50, 0, 0, 0",
        "bonuses": "columnClear",
        "specials": "C:1x2",
        "specialsRandom": "yes",
        "specialsMax": "4",
        "layout": "????????????????????????????????????????*>*>*>*>*>..........0000213333000021333300002133331212121212"
    },
    {
        "level": "25",
        "scoreStars": "5000, 15000, 20000",
        "collectFruits": "yes",
        "movesLimit": "65",
        "colors": "0123",
        "layouts": "100, 10, 2, 1",
        "bonuses": "rowClear",
        "layoutFruitCount": "9, 99",
        "layout": "????????????????????????????????????????????????????????????????Y>????????*>?????222G>222?2222..2222"
    },
    {
        "level": "26",
        "scoreStars": "5000, 10000, 12000",
        "cookieGoal": "10",
        "movesLimit": "85",
        "colors": "01234",
        "layouts": "50, 25, 0, 0",
        "bonuses": "rowClear, columnClear, bomb",
        "specials": "C:1x2",
        "specialsRandom": "yes",
        "specialsMax": "2",
        "layout": "?*??????*??.??????.??3??????3??2??????2??10?????1??00?????0??30?????3?020?????2?010?????1?000?????0?"
    },
    {
        "level": "27",
        "scoreStars": "5000, 7000, 10000",
        "collectFruits": "yes",
        "movesLimit": "50",
        "colors": "01234",
        "layouts": "100, 2, 2, 1",
        "bonuses": "bomb, columnClear",
        "layoutFruitCount": "9, 15, 9",
        "layout": "??????????????????????????????????????????????????????????????????????????????????*>*>*>?????PY>P???"
    },
    {
        "level": "28",
        "scoreStars": "5000, 9000, 12000",
        "cookieGoal": "10",
        "movesLimit": "95",
        "colors": "01234",
        "layouts": "100, 0, 0, 15",
        "bonuses": "columnClear",
        "specials": "C:1x1",
        "specialsRandom": "yes",
        "specialsMax": "5",
        "layout": "??????????????????????????????????????????????????????????????????????*?*?*?*?*?0>1>2>3>4>.........."
    },
    {
        "level": "29",
        "scoreStars": "12000, 16000, 21000",
        "scoreGoal": "15000",
        "movesLimit": "25",
        "colors": "1234",
        "layouts": "100, 2, 2, 2",
        "bonuses": "bomb, rowClear, columnClear",
        "layout": "????????????????????????????????????????????????????????????????????????????????????????????????????"
    },
    {
        "level": "30",
        "scoreStars": "5000, 10000, 20000",
        "bossHealth": "15",
        "movesLimit": "100",
        "colors": "01234",
        "layouts": "50, 3, 0, 0",
        "bonuses": "bomb",
        "hintText": "tutorial.boss",
        "hintIcon": "ProfessorScared",
        "hintLayout": "BottomTutorialWindow",
        "layout": "#12####21##21####12##12####21#3333>3>3333333??33331212??12124333??34443411??124343222111343411122243"
    }
]