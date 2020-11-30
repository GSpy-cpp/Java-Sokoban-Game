package com.zetcode;

	public class Level {
		protected String level
	  = "    ######\n"
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
	
	protected String level2
	  ="   #####\n"
	  +"####   #\n"
	  +"#  #$  #####\n"
	  +"# $$       #\n"
	  +"#@   #$ $# #\n"
	  +"###  #   # #\n"
	  +" #   ##### #\n"
	  +" #   ..... #\n"
	  +" ###########\n";
	
	protected String level3
	  ="##########\n"
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
	
	protected String level4
	  =" #######\n"
	  +" #@    #\n"
	  +"##$##$$#\n"
	  +"# $    #\n"
	  +"# ##$# ##\n"
	  +"#.......#\n"
	  +"### ##  #\n"
	  +"#     $$#\n"
	  +"#   #   #\n"
	  +"#########\n";
	
	protected String level5
	  = "      ########\n"
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
	
	public Level() {
	}
	
	public String Level(int lv) {
		switch(lv) {
		case 1:
			break;
		case 2:
			level = level2;
			break;
		case 3:
			level = level3;
			break;
		case 4:		
			level = level4;
			break;
		case 5:
			level = level5;
			break;
	}
		return level;
	}

}
