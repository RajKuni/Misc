
struct Results solution(char *S, int P[], int Q[], int M) {
    
    struct Results result;
    
    //array for results, allocate space on heap
    int *resultList;
    resultList = (int *)malloc(sizeof(int)*M);
  
	//prefix arrays that will keep track of how many A, C, G, seen upto current index	
	//don't need to keep track of Ts
	
	size_t seqLen = strlen(S);
	seqLen = seqLen + 1;
	
    int A[seqLen];
    int C[seqLen];
    int G[seqLen];
    
    //for some reason, arrays were not initializing to 0, so used memset
    memset(A, 0, seqLen*sizeof(int));
	memset(C, 0, seqLen*sizeof(int));
	memset(G, 0, seqLen*sizeof(int));

	//iterate through all characters and fill in prefix arrays
	int maxA = 0;
	int maxC = 0;
	int maxG = 0;
	
	for(int i = 0; i < seqLen; ++i)
	{
		char current = *(S + i);
		
		if(current == 'A')
		{
			A[i + 1] = 1 + maxA;
			C[i + 1] = maxC;
			G[i + 1] = maxG;
			++maxA;
		}
		else if(current == 'C')
		{
			C[i + 1] = 1 + maxC;
			A[i + 1] = maxA;
		    G[i + 1] = maxG;
		    ++maxC;
		}
		else if(current == 'G')
		{
			G[i + 1] = 1 + maxG;
			A[i + 1] = maxA;
		    C[i + 1] = maxC;
		    ++maxG;
		}
		else
		{
		    A[i + 1] = maxA;
		    C[i + 1] = maxC;
		    G[i + 1] = maxG;
		}
		/*printf("A: %d  ", A[i]);
	    printf("C: %d  ", C[i]);
	    printf("G: %d  ", G[i]);
	    printf("\n");*/
	}
	
    //iterate through P & Q
    for(int i = 0; i < M; ++i)
    {
        int start = P[i];
        int end = Q[i];
        end = end + 1;
   		
	    //check prefix arrays to see if new A, C, or G popped up within sub-string
		int newA = A[end] - A[start];
		int newC = C[end] - C[start];
		int newG = G[end] - G[start];
		//printf("%d, %d\n", A[start], A[end]);
        
		if(newA > 0)
		{	
        	*(resultList + i) = 1;
			continue;
		}
		else if(newC > 0)
		{
        	*(resultList + i) = 2;
			continue;
		}
		else if(newG > 0)
		{
        	*(resultList + i) = 3;
			continue;
		}
		else
		{
        	*(resultList + i) = 4;
			continue;
		}
         
    }

    result.A = resultList;
    result.M = M;
    return result;
}
