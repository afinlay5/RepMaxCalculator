 /**
  * @author	ADRIAN D. FINLAY
  * REP MAX CALCULATOR(RMC)
  *
  */

package com.adriandavid.me;

///NSCA DEADLIFT
class NSCAD extends NSCA {
	
	private double maxlb;
	private short repnum;
	private final double[] REP = new double[] {1.000, 1.065, 1.13, 1.147, 1.164, 1.181, 1.198, 1.22, 1.232, 1.240};
	private final double[]  maxArray = new double [10];
	private static final NSCAD NSCADob = new NSCAD();
	
	//Singleton
	private NSCAD () { };

	//package-private Factory
	protected static NSCA getInstance() { return NSCADob; }

	@Override 
	protected NSCA setData (double maxlb, short repnum) {
		this.maxlb = maxlb;
		this.repnum = repnum;
		return NSCADob;
	}

	@Override
	protected double [] computeMax () {
					
		//REPS #1-10
		switch (repnum) {
			case 1: {
				for (var i=0; i<maxArray.length; i++) {
					if (i==0) 
						maxArray[i] = maxlb;
					else
						maxArray[i] = maxlb/REP[i];
				}
				break;
			}
			
			case 2: {
				for (var i=0; i<maxArray.length; i++) {
					if (i==0) 
						maxArray[i] = maxlb*REP[1];
					else if (i==1)
						maxArray[i] = maxlb;
					else
						maxArray[i] = maxlb/REP[i];
				}
				break;
			}

			case 3: {
				for (var i=0; i<maxArray.length; i++) {
					if (i==0) 
						maxArray[i] = maxlb*REP[2];
					else if (i==2)
						maxArray[i] = maxlb;
					else
						maxArray[i] = maxlb/REP[i];
				}
				break;
			}

			case 4: {
				for (var i=0; i<maxArray.length; i++) {
					if (i==0) 
						maxArray[i] = maxlb*REP[3];
					else if (i==3)
						maxArray[i] = maxlb;
					else
						maxArray[i] = maxlb/REP[i];
				}
				break;
			}

			case 5: {
				for (var i=0; i<maxArray.length; i++) {
					if (i==0) 
						maxArray[i] = maxlb*REP[4];
					else if (i==4)
						maxArray[i] = maxlb;
					else
						maxArray[i] = maxlb/REP[i];
				}
				break;
			}

			case 6: {
				for (var i=0; i<maxArray.length; i++) {
					if (i==0) 
						maxArray[i] = maxlb*REP[5];
					else if (i==5)
						maxArray[i] = maxlb;
					else
						maxArray[i] = maxlb/REP[i];
				}
				break;
			}

			case 7: {
				for (var i=0; i<maxArray.length; i++) {
					if (i==0) 
						maxArray[i] = maxlb*REP[6];
					else if (i==6)
						maxArray[i] = maxlb;
					else
						maxArray[i] = maxlb/REP[i];
				}
				break;
			}
		
			case 8: {
				for (var i=0; i<maxArray.length; i++) {
					if (i==0) 
						maxArray[i] = maxlb*REP[7];
					else if (i==7)
						maxArray[i] = maxlb;
					else
						maxArray[i] = maxlb/REP[i];
				}
				break;
			}
			
			case 9: {
				for (var i=0; i<maxArray.length; i++) {
					if (i==0) 
						maxArray[i] = maxlb*REP[8];
					else if (i==8)
						maxArray[i] = maxlb;
					else
						maxArray[i] = maxlb/REP[i];
				}
				break;
			}

			case 10: {
				for (var i=0; i<maxArray.length; i++) {
					if (i==0) 
						maxArray[i] = maxlb*REP[9];
					else if (i==9)
						maxArray[i] = maxlb;
					else
						maxArray[i] = maxlb/REP[i];
				}
				break;
			}
		}
		return maxArray;
	}	
}