class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int boatCount = 0;
        int p1 = 0;
        int p2 = people.length-1;
        while(p1 <= p2) {
            if(p1 == p2){
                boatCount++;
                break;
            }
            int sum = people[p1] + people[p2];
            if(sum <= limit) {
                boatCount++;
                p1++;
                p2--;
            }else{
                boatCount++;
                sum = 0;
                p2--;
            }
        }
        
        
        return boatCount;
    }
}