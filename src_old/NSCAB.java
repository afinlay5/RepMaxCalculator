 /**
  * @author	ADRIAN D. FINLAY
  * REP MAX CALCULATOR(RMC)
  *
  */

import static java.lang.Math.round;

///NSCA BENCH PRESS
class NSCAB {
	
	int maxlb, repnum;
	// 1.000	1.035	1.08	1.115	1.15	1.18	1.22	1.255	1.29	1.325
	private final double REP1 = (1.000);
	private final double REP2 = (1.035);
	private final double REP3 = (1.08);
	private final double REP4 = (1.115);
	private final double REP5 = (1.15);
	private final double REP6 = (1.18);
	private final double REP7 = (1.22);
	private final double REP8 = (1.255);
	private final double REP9 = (1.29);
	private final double REP10 = (1.325);

			
	//Constructor
	NSCAB (double lifted, double reps) {
		maxlb = (int) (round(lifted));
		repnum = (int) (round(reps));
	}
	
	//Methods
	int [] computeMax () {
			
		int maxArray [] = new int [10];
		//REPS #1-10
		switch (repnum) {
			case 1: {
				maxArray [0] = (short) maxlb;
				maxArray [1] = (short) (maxlb/REP2);
				maxArray [2] = (short) (maxlb/REP3);
				maxArray [3] = (short) (maxlb/REP4);
				maxArray [4] = (short) (maxlb/REP5);
				maxArray [5] = (short) (maxlb/REP6);
				maxArray [6] = (short) (maxlb/REP7);
				maxArray [7] = (short) (maxlb/REP8);
				maxArray [8] = (short) (maxlb/REP9);
				maxArray [9] = (short) (maxlb/REP10);
			}
			break;
			case 2: {
				maxArray [0] = (short) (maxlb*REP2);
				maxArray [1] = (short) maxlb;
				maxArray [2] = (short) (maxArray[0]/REP3);
				maxArray [3] = (short) (maxArray[0]/REP4);
				maxArray [4] = (short) (maxArray[0]/REP5);
				maxArray [5] = (short) (maxArray[0]/REP6);
				maxArray [6] = (short) (maxArray[0]/REP7);
				maxArray [7] = (short) (maxArray[0]/REP8);
				maxArray [8] = (short) (maxArray[0]/REP9);
				maxArray [9] = (short) (maxArray[0]/REP10);
			}
			break;
			case 3: {
				maxArray [0] = (short) (maxlb*REP3);
				maxArray [1] = (short) (maxArray[0]/REP2);
				maxArray [2] = (short) maxlb;
				maxArray [3] = (short) (maxArray[0]/REP4);
				maxArray [4] = (short) (maxArray[0]/REP5);
				maxArray [5] = (short) (maxArray[0]/REP6);
				maxArray [6] = (short) (maxArray[0]/REP7);
				maxArray [7] = (short) (maxArray[0]/REP8);
				maxArray [8] = (short) (maxArray[0]/REP9);
				maxArray [9] = (short) (maxArray[0]/REP10);
			}
			break;
			case 4: {
				maxArray [0] = (short) (maxlb*REP4);
				maxArray [1] = (short) (maxArray[0]/REP2);
				maxArray [2] = (short) (maxArray[0]/REP3);
				maxArray [3] = (short) maxlb;
				maxArray [4] = (short) (maxArray[0]/REP5);
				maxArray [5] = (short) (maxArray[0]/REP6);
				maxArray [6] = (short) (maxArray[0]/REP7);
				maxArray [7] = (short) (maxArray[0]/REP8);
				maxArray [8] = (short) (maxArray[0]/REP9);
				maxArray [9] = (short) (maxArray[0]/REP10);
			}
			break;
			case 5: {
				maxArray [0] = (short) (maxlb*REP5);
				maxArray [1] = (short) (maxArray[0]/REP2);
				maxArray [2] = (short) (maxArray[0]/REP3);
				maxArray [3] = (short) (maxArray[0]/REP4);
				maxArray [4] = (short) maxlb;
				maxArray [5] = (short) (maxArray[0]/REP6);
				maxArray [6] = (short) (maxArray[0]/REP7);
				maxArray [7] = (short) (maxArray[0]/REP8);
				maxArray [8] = (short) (maxArray[0]/REP9);
				maxArray [9] = (short) (maxArray[0]/REP10);
			}
			break;
			case 6: {
				maxArray [0] = (short) (maxlb*REP6);
				maxArray [1] = (short) (maxArray[0]/REP2);
				maxArray [2] = (short) (maxArray[0]/REP3);
				maxArray [3] = (short) (maxArray[0]/REP4);
				maxArray [4] = (short) (maxArray[0]/REP5);
				maxArray [5] = (short) maxlb;
				maxArray [6] = (short) (maxArray[0]/REP7);
				maxArray [7] = (short) (maxArray[0]/REP8);
				maxArray [8] = (short) (maxArray[0]/REP9);
				maxArray [9] = (short) (maxArray[0]/REP10);
			}
			break;
			case 7: {
				maxArray [0] = (short) (maxlb*REP7);
				maxArray [1] = (short) (maxArray[0]/REP2);
				maxArray [2] = (short) (maxArray[0]/REP3);
				maxArray [3] = (short) (maxArray[0]/REP4);
				maxArray [4] = (short) (maxArray[0]/REP5);
				maxArray [5] = (short) (maxArray[0]/REP6);
				maxArray [6] = (short) 	maxlb;
				maxArray [7] = (short) (maxArray[0]/REP8);
				maxArray [8] = (short) (maxArray[0]/REP9);
				maxArray [9] = (short) (maxArray[0]/REP10);
			}
			break;
			case 8: {
				maxArray [0] = (short) (maxlb*REP8);
				maxArray [1] = (short) (maxArray[0]/REP2);
				maxArray [2] = (short) (maxArray[0]/REP3);
				maxArray [3] = (short) (maxArray[0]/REP4);
				maxArray [4] = (short) (maxArray[0]/REP5);
				maxArray [5] = (short) (maxArray[0]/REP6);
				maxArray [6] = (short) (maxArray[0]/REP7);
				maxArray [7] = (short) maxlb;
				maxArray [8] = (short) (maxArray[0]/REP9);
				maxArray [9] = (short) (maxArray[0]/REP10);
			}
			break;
			case 9: {
				maxArray [0] = (short) (maxlb*REP9);
				maxArray [1] = (short) (maxArray[0]/REP2);
				maxArray [2] = (short) (maxArray[0]/REP3);
				maxArray [3] = (short) (maxArray[0]/REP4);
				maxArray [4] = (short) (maxArray[0]/REP5);
				maxArray [5] = (short) (maxArray[0]/REP6);
				maxArray [6] = (short) (maxArray[0]/REP7);
				maxArray [7] = (short) (maxArray[0]/REP8);
				maxArray [8] = (short) maxlb;
				maxArray [9] = (short) (maxArray[0]/REP10);
			}
			break;
			case 10: {
				maxArray [0] = (short) (maxlb*REP10);
				maxArray [1] = (short) (maxArray[0]/REP2);
				maxArray [2] = (short) (maxArray[0]/REP3);
				maxArray [3] = (short) (maxArray[0]/REP4);
				maxArray [4] = (short) (maxArray[0]/REP5);
				maxArray [5] = (short) (maxArray[0]/REP6);
				maxArray [6] = (short) (maxArray[0]/REP7);
				maxArray [7] = (short) (maxArray[0]/REP8);
				maxArray [8] = (short) (maxArray[0]/REP9);
				maxArray [9] = (short) maxlb;
			}
			break;
			//Invalid Entry
			default:  {
				for (short i=0; i<maxArray.length; i++) {
					maxArray[i] = 1;
				}
					break;
			}
		}
		return maxArray;
	}	
	
}