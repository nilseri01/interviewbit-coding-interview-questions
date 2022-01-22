// https://www.interviewbit.com/problems/gas-station/
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        if (A.size() == 1 && A.get(0) >= B.get(0)) {
            return 0;
        }

        List<Integer> remaining = new ArrayList<>();
        for (int i=0; i < A.size(); i++) {
            remaining.add(A.get(i) - B.get(i));
        }

        for (int i=0; i < A.size(); i++) {
            Integer gasTank = remaining.get(i);
            if (gasTank > 0) {
                int j=i+1;
                while(j<A.size() && gasTank>0) {
                    gasTank += remaining.get(j);
                    j++;
                }
                j=0;
                while(j<i && gasTank>0) {
                    gasTank += remaining.get(j);
                    j++;
                }
                if (i==j && gasTank>=0) {
                    return i;
                }
            }
        }
        return -1;
    }
}
