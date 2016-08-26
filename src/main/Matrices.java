package main;

public class Matrices {

	public static void main(String[] args) throws Exception{

		//planarMatrix();
		//randomMatrix();
		//baMatrix();
		//treeMatrix();
		//kTreeMatrix();
		caterpillarMatrix("1");
		
	}
	
	public static void caterpillarMatrix(String idExperiment) throws Exception{


		int familyId = 6; // Caterpillar

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {""};
		String[] meas_arr = {"ply"};
		String[] instances = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		//FMMM, FR, GEM, KK, SM 
		String[] algorithms = {"1", "2", "3", "4", "6"};


		QueryInstance qi = new QueryInstance();
		qi.name = "Caterpillar";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;


		printMatrix(qi);
	}

	public static void planarMatrix(String idExperiment) throws Exception{


		int familyId = 1; // PLANAR

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {""};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		//FMMM, FR, GEM, KK, SM 
		String[] algorithms = {"1", "2", "3", "4", "5", "6"};


		QueryInstance qi = new QueryInstance();
		qi.name = "Planar";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;


		printMatrix(qi);
	}
	
	public static void randomMatrix(String idExperiment) throws Exception{


		int familyId = 2; // RANDOM

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {"1.5", "2.5"};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		//FMMM, FR, GEM, KK, SM 
		String[] algorithms = {"1", "2", "3", "4", "6"};


		QueryInstance qi = new QueryInstance();
		qi.name = "Random";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;


		printMatrix(qi);
	}

	public static void baMatrix(String idExperiment) throws Exception{


		int familyId = 3; // BA

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {"2", "3"};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		//FMMM, FR, GEM, KK, SM 
		String[] algorithms = {"1", "2", "3", "4", "6"};


		QueryInstance qi = new QueryInstance();
		qi.name = "BA";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;


		printMatrix(qi);
	}

	
	public static void treeMatrix(String idExperiment) throws Exception{


		int familyId = 4; // Tree

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {""};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		//FMMM, FR, GEM, KK, SM 
		String[] algorithms = {"1", "2", "3", "4", "6", "5"};


		QueryInstance qi = new QueryInstance();
		qi.name = "TREE";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;


		printMatrix(qi);
	}
	
	public static void kTreeMatrix(String idExperiment) throws Exception{


		int familyId = 5; // Tree

		String[] type_1_Arr = {"55", "100", "103", "151", "154", "199"};
		String[] type_2_Arr = {"3", "6", "9"};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		//FMMM, FR, GEM, KK, SM 
		String[] algorithms = {"1", "2", "3", "4", "6", "5", "7", "8"};


		QueryInstance qi = new QueryInstance();
		qi.name = "TREE";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;


		printMatrix(qi);
	}


	//////////////////
	//////////////////
	//////////////////
	//////////////////
	private static void printMatrix(QueryInstance qi) throws Exception{


		MySQLGateway db = MySQLGateway.getInstance();

		for(String value : qi.meas_arr){

			System.out.println(qi.name);
			System.out.println(value + " Matrix");

			for(String t2 : qi.type_2_Arr){
				System.out.println(t2);
				System.out.print(";");
				for(String a : qi.algorithms)
					System.out.print(a + ";");
				System.out.println();
				
				for(String t1 : qi.type_1_Arr){
					String row = t1+";";
					for(String a : qi.algorithms){
						row += db.avg(qi.familyId, a, t1, t2, value, qi.experiment) + ";";	
					}
					System.out.println(row);
				}

				System.out.println("\n\n\n");

			}
		}
	}


}
