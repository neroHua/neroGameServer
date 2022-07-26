package com.nero.hua.enumeration;

import lombok.Getter;

@Getter
public enum CardEnumeration {

    CARD_103("card_103", 3, "方块3"),
    CARD_104("card_104", 4, "方块4"),
    CARD_105("card_105", 5, "方块5"),
    CARD_106("card_106", 6, "方块6"),
    CARD_107("card_107", 7, "方块7"),
    CARD_108("card_108", 8, "方块8"),
    CARD_109("card_109", 9, "方块9"),
    CARD_110("card_110", 10, "方块10"),
    CARD_111("card_111", 11, "方块J"),
    CARD_112("card_112", 12, "方块Q"),
    CARD_113("card_113", 13, "方块K"),
    CARD_114("card_114", 14, "方块1"),
    CARD_115("card_115", 15, "方块2"),
    CARD_203("card_203", 3, "梅花3"),
    CARD_204("card_204", 4, "梅花4"),
    CARD_205("card_205", 5, "梅花5"),
    CARD_206("card_206", 6, "梅花6"),
    CARD_207("card_207", 7, "梅花7"),
    CARD_208("card_208", 8, "梅花8"),
    CARD_209("card_209", 9, "梅花9"),
    CARD_210("card_210", 10, "梅花10"),
    CARD_211("card_211", 11, "梅花J"),
    CARD_212("card_212", 12, "梅花Q"),
    CARD_213("card_213", 13, "梅花K"),
    CARD_214("card_214", 14, "梅花1"),
    CARD_215("card_215", 15, "梅花2"),
    CARD_303("card_303", 3, "红桃3"),
    CARD_304("card_304", 4, "红桃4"),
    CARD_305("card_305", 5, "红桃5"),
    CARD_306("card_306", 6, "红桃6"),
    CARD_307("card_307", 7, "红桃7"),
    CARD_308("card_308", 8, "红桃8"),
    CARD_309("card_309", 9, "红桃9"),
    CARD_310("card_310", 10, "红桃10"),
    CARD_311("card_311", 11, "红桃J"),
    CARD_312("card_312", 12, "红桃Q"),
    CARD_313("card_313", 13, "红桃K"),
    CARD_314("card_314", 14, "红桃1"),
    CARD_315("card_315", 15, "红桃2"),
    CARD_403("card_403", 3, "黑桃3"),
    CARD_404("card_404", 4, "黑桃4"),
    CARD_405("card_405", 5, "黑桃5"),
    CARD_406("card_406", 6, "黑桃6"),
    CARD_407("card_407", 7, "黑桃7"),
    CARD_408("card_408", 8, "黑桃8"),
    CARD_409("card_409", 9, "黑桃9"),
    CARD_410("card_410", 10, "黑桃10"),
    CARD_411("card_411", 11, "黑桃J"),
    CARD_412("card_412", 12, "黑桃Q"),
    CARD_413("card_413", 13, "黑桃K"),
    CARD_414("card_414", 14, "黑桃1"),
    CARD_415("card_415", 15, "黑桃2"),
    CARD_500("card_500", 0, "背面"),
    CARD_508("card_508", 8, "狗子"),
    CARD_516("card_516", 16, "小王"),
    CARD_517("card_517", 17, "大王");

    private String code;
    private int value;
    private String message;

    CardEnumeration(String code, int value, String message) {
        this.code = code;
        this.value = value;
        this.message = message;
    }
}
