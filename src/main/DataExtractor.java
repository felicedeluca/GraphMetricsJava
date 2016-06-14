package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataExtractor {


	public static void main(String[] args) throws Exception{


		planarCorrelation("2");
		randomCorrelation("2");
		baCorrelation("2");
		treeCorrelation("2");

	}

	static void planarCorrelation(String idExperiment) throws Exception{

		int familyId = 1; // planar;
		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {""};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};


		QueryInstance qi = new QueryInstance();
		qi.name = "Planar";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.experiment = idExperiment;

		print(qi);

	}

	static void randomCorrelation(String idExperiment) throws  Exception{


		int familyId = 2; // Random;

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {"1.5", "2.5"};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};

		QueryInstance qi = new QueryInstance();
		qi.name = "Random";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.experiment = idExperiment;


		print(qi);


	}


	static void baCorrelation(String idExperiment) throws Exception{


		int familyId = 3; // BA;

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {"2", "3"};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};
		//FMMM, FR, GEM, KK, SM 


		QueryInstance qi = new QueryInstance();
		qi.name = "BA";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.experiment = idExperiment;


		print(qi);

	}

	static void treeCorrelation(String idExperiment) throws Exception{


		int familyId = 4; // Tree;

		String[] type_1_Arr = {"50", "100", "150", "200"};
		String[] type_2_Arr = {""};
		String[] meas_arr = {"ply", "full_stress", "crossings", "unif_e_len"};
		String[] instances = {"1"};

		QueryInstance qi = new QueryInstance();
		qi.name = "Tree";
		qi.familyId = familyId;
		qi.type_1_Arr = type_1_Arr;
		qi.type_2_Arr = type_2_Arr;
		qi.meas_arr = meas_arr;
		qi.instances = instances;
		qi.experiment = idExperiment;


		print(qi);

	}


	static void print(QueryInstance qi) throws Exception{

		int m_i = 0;
			for(String type_2 : qi.type_2_Arr)
				for(String type_1 : qi.type_1_Arr)
					for(String instance : qi.instances)
						printData(qi.familyId, "", type_1, type_2, "", instance, "", "", qi.experiment);
	}

	static void printData(int family, String algorithm, String type_1, String type_2, String type_3, String instance, String measure1, String measure2, String idExperiment) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		MySQLGateway db = MySQLGateway.getInstance();

		ArrayList<Element> elements = db.fetchElements4(family, algorithm, type_1, type_2, type_3, instance, "ply", "full_stress", "crossings", "unif_e_len", idExperiment);

		System.out.println(measure1 + "\t" + measure2);
		
		String familyName = "";
		
		switch(family){
		case 1 : 
			familyName = "Planar";
			break;
		case 2:
			familyName = "General";
			break;
		case 3:
			familyName = "ScaleFree";
			break;
		case 4:
			familyName = "Trees";
			break;
			default:
				familyName = family+ "";
		}
		
		String filename = familyName + "_" + type_1 + "_" + type_2;
		
		storeInFile(filename, elements);

	}


	static void storeInFile(String filename, ArrayList<Element> elements){


		String path = filename+".txt";
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file);
			for(Element el : elements){
				String row = el.getX() + "\t" + el.getY() + "\t" + el.getZ() +"\t" + el.getK() + System.getProperty("line.separator");
				fw.write(row.replaceAll("\\.", ","));
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
