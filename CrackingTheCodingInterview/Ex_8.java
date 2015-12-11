// all subsets of set

public ArrayList<ArrayList<Integer>> 
getSubsets(ArrayList<Integer> set)
{
	ArrayList<ArrayList<Integer>> allSubsets;

	allSubsets = helperSubset(allSubsets, set);

	return allSubsets;
}

public ArrayList<ArrayList<Integer>> helperSubset(ArrayList<
