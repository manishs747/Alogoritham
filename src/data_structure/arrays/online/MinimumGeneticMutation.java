package data_structure.arrays.online;


/**
 * https://leetcode.com/problems/minimum-genetic-mutation/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinimumGeneticMutation {

    public static void main(String[] args) {
       String startGene = "AACCGGTT", endGene = "AAACGGTA";
       String [] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
       System.out.println(minMutation(startGene,endGene,bank));
    }

    public static int minMutation(String startGene, String endGene, String[] bank) {


        return -1;
    }

}
