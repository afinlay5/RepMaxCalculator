 /**
  * @author	ADRIAN D. FINLAY
  * REP MAX CALCULATOR(RMC)
  *
  */

package com.adriandavid.me;

///NSCA SQUAT
class NSCAS extends NSCA {
	
	private double maxlb;
	private short repnum;
	private final double[] REP = new double[] {1.000,1.0475,1.13,1.1575,1.2,1.242,1.284,1.326,1.368,1.410 };
	private final double[]  maxArray = new double [10];
	private static final NSCAS NSCASob = new NSCAS();
	
	//Singleton
	private NSCAS () { };

	//package-private Factory
	protected static NSCA getInstance() { return NSCASob; }

	@Override 
	protected NSCA setData (double maxlb, short repnum) {
		this.maxlb = maxlb;
		this.repnum = repnum;
		return NSCASob;
	}

	@Override
	protected double [] computeMax () {
					
		//REPS #1-10
		switch (repnum) {
			case 1: {
				for (var i1=0; i1<maxArray.length; i1++) {
					if (i1==0) {
						maxArray[i1] = maxlb;
						System.out.println(maxArray[0]);
					}
					else
						maxArray[i1] = maxlb/REP[i1];
				}
				break;
			}
			
			case 2: {
				for (var i2=0; i2<maxArray.length; i2++) {
					if (i2==0) 
						maxArray[i2] = maxlb*REP[1];
					else if (i2==1)
						maxArray[i2] = maxlb;
					else
						maxArray[i2] = maxlb/REP[i2];
				}
				break;
			}

			case 3: {
				for (var i3=0; i3<maxArray.length; i3++) {
					if (i3==0) 
						maxArray[i3] = maxlb*REP[2];
					else if (i3==2)
						maxArray[i3] = maxlb;
					else
						maxArray[i3] = maxlb/REP[i3];
				}
				break;
			}

			case 4: {
				for (var i4=0; i4<maxArray.length; i4++) {
					if (i4==0) 
						maxArray[i4] = maxlb*REP[3];
					else if (i4==3)
						maxArray[i4] = maxlb;
					else
						maxArray[i4] = maxlb/REP[i4];
				}
				break;
			}

			case 5: {
				for (var i5=0; i5<maxArray.length; i5++) {
					if (i5==0) 
						maxArray[i5] = maxlb*REP[4];
					else if (i5==4)
						maxArray[i5] = maxlb;
					else
						maxArray[i5] = maxlb/REP[i5];
				}
				break;
			}

			case 6: {
				for (var i6=0; i6<maxArray.length; i6++) {
					if (i6==0) 
						maxArray[i6] = maxlb*REP[5];
					else if (i6==5)
						maxArray[i6] = maxlb;
					else
						maxArray[i6] = maxlb/REP[i6];
				}
				break;
			}

			case 7: {
				for (var i7=0; i7<maxArray.length; i7++) {
					if (i7==0) 
						maxArray[i7] = maxlb*REP[6];
					else if (i7==6)
						maxArray[i7] = maxlb;
					else
						maxArray[i7] = maxlb/REP[i7];
				}
				break;
			}
		
			case 8: {
				for (var i8=0; i8<maxArray.length; i8++) {
					if (i8==0) 
						maxArray[i8] = maxlb*REP[7];
					else if (i8==7)
						maxArray[i8] = maxlb;
					else
						maxArray[i8] = maxlb/REP[i8];
				}
				break;
			}
			
			case 9: {
				for (var i9=0; i9<maxArray.length; i9++) {
					if (i9==0) 
						maxArray[i9] = maxlb*REP[8];
					else if (i9==8)
						maxArray[i9] = maxlb;
					else
						maxArray[i9] = maxlb/REP[i9];
				}
				break;
			}

			case 10: {
				for (var i10=0; i10<maxArray.length; i10++) {
					if (i10==0) 
						maxArray[i10] = maxlb*REP[9];
					else if (i10==9)
						maxArray[i10] = maxlb;
					else
						maxArray[i10] = maxlb/REP[i10];
				}
				break;
			}
		}
		return maxArray;
	}	
}