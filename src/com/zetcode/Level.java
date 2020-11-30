package com.zetcode;

public class Level {
	public Level() {
	}
	
	public String Level(int lv) {
		String map = null;
		switch(lv) {
		case 1:
			map =
			"    ######\n"
          + "    ##   #\n"
          + "    ##$  #\n"
          + "  ####  $##\n"
          + "  ##  $ $ #\n"
          + "#### # ## #   ######\n"
          + "##   # ## #####  ..#\n"
          + "## $  $          ..#\n"
          + "###### ### #@##  ..#\n"
          + "    ##     #########\n"
          + "    ########\n";
		break;
		
		case 2:
			map = 
			 "   #####\n"
			+"####   #\n"
			+"#  #$  #####\n"
			+"# $$       #\n"
			+"#@   #$ $# #\n"
			+"###  #   # #\n"
			+" #   ##### #\n"
			+" #   ..... #\n"
			+" ###########\n";
		break;

		case 3:
			map = 
			"##########\n"
			+"#     #  #\n"
			+"#  $  $$ #\n"
			+"#  # #   #\n"
	        +"#### ###.#\n"
	        +"#  #   #.#\n"
	        +"# $  $ #.#\n"
	        +"#  ##.##.#\n"
	        +"##.##  #.#\n"
	        +"# $  $ #.#\n"
	        +"#   #  #.#\n"
	        +"### ####.#\n"
	        +"### #  @ #\n"
	        +"#  $  $$ #\n"
	        +"#        #\n"
	        +"##########\n";
		break;
		
		case 4:
			map = 
			" #######\n"
	        +" #@    #\n"
	        +"##$##$$#\n"
	        +"# $    #\n"
	        +"# ##$# ##\n"
	        +"#.......#\n"
	        +"### ##  #\n"
	        +"#     $$#\n"
	        +"#   #   #\n"
	        +"#########\n";

		case 5:
			map = 
	          "      ########\n"
	        + "      #      #\n"
	        + "  ##### #### #\n"
	        + "  #   # #  # #\n"
	        + "  #        # #\n"
	        + "#### ####  # #\n"
	        + "#  $$## $$## #\n"
	        + "# ##.......  #\n"
	        + "# #   ## #####\n"
	        + "# # $$$  #\n"
	        + "# ### ####\n"
	        + "#@     #\n"
	        + "#######\n";
	}
		return map;
	}

}
