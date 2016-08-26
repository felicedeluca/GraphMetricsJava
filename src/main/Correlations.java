package main;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Correlations {

	public static void main(String[] args) throws Exception {
		
		String idTest = "2";
		final boolean graphFixed = false;
		final boolean algorithmFixed = true;
		
		//ID Experiment (2 or 100), Type

		//planarCorrelation(idTest,graphFixed);
		//randomCorrelation(idTest,graphFixed);
		//baCorrelation(idTest,graphFixed);
		//treeCorrelation(idTest,graphFixed);
		//kTreeCorrelation(idTest, graphFixed);
		
		caterpillarCorrelation(idTest, graphFixed);
		cyclesCorrelation(idTest, graphFixed);
		pathsCorrelation(idTest, graphFixed);
		
		//String filename = args[0];
		
		//fileCorrelation(filename);
		

	}
	
	static void fileCorrelation(String filename){
		
		ArrayList<Element> elements = Element.fetchFromFile(new File(filename));
	
		double[] x = new double[elements.size()];
		double[] y = new double[elements.size()];

		for(int i=0; i<elements.size(); i++){
			x[i] = elements.get(i).getX();
			y[i] = elements.get(i).getY();
		}

		double corr = spearman(x,y);

		System.out.println(filename + " corrlation: " + corr);	
		
	}
	
	static void caterpillarCorrelation(String idExperiment, boolean fixAlgorithm) throws Exception{

		int familyId = 6; // caterpillar;
		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {""};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};
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

		printCorrelations(qi, fixAlgorithm);

	}
	
	static void cyclesCorrelation(String idExperiment, boolean fixAlgorithm) throws Exception{

		int familyId = 7; // caterpillar;
		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {""};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};
		String[] algorithms = {"1", "2", "3", "4", "6"};


		QueryInstance qi = new QueryInstance();
		qi.name = "Cycles";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;

		printCorrelations(qi, fixAlgorithm);

	}
	
	static void pathsCorrelation(String idExperiment, boolean fixAlgorithm) throws Exception{

		int familyId = 8; // paths;
		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {""};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};
		String[] algorithms = {"1", "2", "3", "4", "6"};


		QueryInstance qi = new QueryInstance();
		qi.name = "Paths";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;

		printCorrelations(qi, fixAlgorithm);

	}


	static void planarCorrelation(String idExperiment, boolean fixAlgorithm) throws Exception{

		int familyId = 1; // planar;
		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {""};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};
		String[] algorithms = {"1", "2", "3", "4", "6", "5", "9"};


		QueryInstance qi = new QueryInstance();
		qi.name = "Planar";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;

		printCorrelations(qi, fixAlgorithm);

	}

	static void randomCorrelation(String idExperiment, boolean fixAlgorithm) throws  Exception{


		int familyId = 2; // Random;

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {"1.5", "2.5"};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};

		//FMMM, FR, GEM, KK, SM 
		String[] algorithms = {"1", "2", "3", "4", "6", "9"};


		QueryInstance qi = new QueryInstance();
		qi.name = "Random";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;


		printCorrelations(qi, fixAlgorithm);


	}


	static void baCorrelation(String idExperiment, boolean fixAlgorithm) throws Exception{


		int familyId = 3; // BA;

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {"2", "3"};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};
		//FMMM, FR, GEM, KK, SM 
		String[] algorithms = {"1", "2", "3", "4", "6", "9"};


		QueryInstance qi = new QueryInstance();
		qi.name = "BA";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;


		printCorrelations(qi, fixAlgorithm);

	}

	static void treeCorrelation(String idExperiment, boolean fixAlgorithm) throws Exception{


		int familyId = 4; // Tree;

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {""};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};

		String[] algorithms = {"1", "2", "3", "4", "6", "5", "9"};


		QueryInstance qi = new QueryInstance();
		qi.name = "Tree";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;


		printCorrelations(qi, fixAlgorithm);

	}

	static void kTreeCorrelation(String idExperiment, boolean fixAlgorithm) throws Exception{

		int familyId = 5; // kTree;

		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		String[] type_1_Arr = {"55", "100", "103", "151", "154", "199"};
		String[] type_2_Arr = {"3", "6", "9"};
		String[] algorithms = {"1"};


		QueryInstance qi = new QueryInstance();
		qi.name = "kTree";
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.familyId = familyId;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.algorithms = algorithms;
		qi.experiment = idExperiment;


		printCorrelations(qi, fixAlgorithm);


	}











	static void printCorrelations(QueryInstance qi, boolean fixAlgorithm) throws Exception{

		String matrix = "";

		if(fixAlgorithm)
			matrix += "Fixed Family and Algorithm\n";
		else
			matrix += "Fixed Family and Graph\n";

		matrix += qi.name + "("+qi.familyId+")\n\n";

		for(int m_i=0; m_i<qi.meas_arr.length; m_i++)
			for (int m_j=m_i+1; m_j<qi.meas_arr.length; m_j++){

				String meas_1 = qi.meas_arr[m_i];
				String meas_2 = qi.meas_arr[m_j];

				matrix += meas_1 + " - " + meas_2 + "\n";

				for(String type_2 : qi.type_2_Arr){
					
					matrix += type_2 + "\n";

					double sum = 0.0;
					double count = 0.0;

					String header = "";

					if(fixAlgorithm){
						header += ";";
						for(String algorithm : qi.algorithms){
							header += algorithm+";";
						}
					}else{
						header += ";";
						for(String instance : qi.instances){
							header += instance+";";
						}
					}

					matrix += header +"\n";

					for(String type_1 : qi.type_1_Arr){

						String row = type_1+";";

						if(fixAlgorithm)
							for(String algorithm : qi.algorithms){
								double corr = getCorrelation(qi.familyId, algorithm, type_1, type_2, "", "", meas_1, meas_2, qi.experiment);
								sum += corr;
								count ++;

								row += corr+";"; 
								//System.out.println(type_1+";"+type_2+";"+algorithm+";"+corr);
							}
						else
							for(String instance : qi.instances){
								double corr = getCorrelation(qi.familyId, "", type_1, type_2, "", instance, meas_1, meas_2, qi.experiment);
								sum += corr;
								count ++;
								row += corr+";"; 

								//System.out.println(type_1+";"+type_2+";"+instance+";"+corr);
							}	

						matrix += row + "\n";

					}



					double avg = sum/count;
					// System.out.println(";;;;;AVG;"+avg);
					matrix += "\n\n\n";
				}

				matrix += "\n\n";
			}

		System.out.println(matrix);

	}



	static double getCorrelation(int family, String algorithm, String type_1, String type_2, String type_3, String instance, String measure1, String measure2, String idExperiment) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{


		MySQLGateway db = MySQLGateway.getInstance();

		//fetchElements(int family, String algorithm, String type_1, String type_2, String type_3, String instance, String measure1, String measure2)
		ArrayList<Element> elements = db.fetchElements(family, algorithm, type_1, type_2, type_3, instance, measure1, measure2, idExperiment);

		double[] x = new double[elements.size()];
		double[] y = new double[elements.size()];

		for(int i=0; i<elements.size(); i++){
			x[i] = elements.get(i).getX();
			y[i] = elements.get(i).getY();
		}

		double corr = spearman(x,y);

		return corr;

	}






	/* ------------------------------------------------- */


	public static double spearman (double[] x, double[] y){

		int x_n = x.length;
		int y_n = y.length;
		double[] x_rank = new double[x_n];
		double[] y_rank = new double[y_n];

		TreeMap<Double,HashSet<Integer>> sorted = new TreeMap<Double,HashSet<Integer>>();
		for (int i = 0; i < x_n; i++){
			double v = x[i];
			if (sorted.containsKey(v) == false) sorted.put(v,new HashSet<Integer>());
			sorted.get(v).add(i);
		}

		int c = 1;
		for (double v : sorted.descendingKeySet()){
			double r = 0;
			for (int i : sorted.get(v)){
				r += c;
				c++;				
			}

			r /= sorted.get(v).size();

			for (int i : sorted.get(v)){
				x_rank[i] = r;
			}
		}

		sorted.clear();
		for (int i = 0; i < y_n; i++){
			double v = y[i];
			if (sorted.containsKey(v) == false) sorted.put(v,new HashSet<Integer>());
			sorted.get(v).add(i);
		}

		c = 1;
		for (double v : sorted.descendingKeySet()){
			double r = 0;
			for (int i : sorted.get(v)){
				r += c;
				c++;				
			}

			r /= sorted.get(v).size();

			for (int i : sorted.get(v)){
				y_rank[i] = r;
			}
		}

		return pearson(x_rank,y_rank);
	}


	public static double pearson (double[] x, double[] y){

		double mean_x = 0;
		double mean_y = 0;
		int n_x = x.length;
		int n_y = y.length;
		for (int i = 0; i < n_x; i++){
			mean_x += x[i];
			mean_y += y[i];
		}
		mean_x /= n_x;
		mean_y /= n_y;

		double cov = 0;
		double sd_x = 0; 
		double sd_y = 0;

		for (int i = 0; i < n_x; i++){
			cov += (x[i] - mean_x) * (y[i] - mean_y);
			sd_x += (x[i] - mean_x) * (x[i] - mean_x);
			sd_y += (y[i] - mean_y) * (y[i] - mean_y);
		}

		if (cov == 0){
			return 0;
		}else{
			double r = cov/(Math.sqrt(sd_x) * Math.sqrt(sd_y));
			return r;
		}				
	}


}
