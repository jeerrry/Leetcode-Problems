class ParkingSystem {
    private final int MIN_CAP;
    private final int MID_CAP;
    private final int BIG_CAP;
    
    private int minCount = 0;
    private int midCount = 0;
    private int bigCount = 0;
    
    public ParkingSystem(int big, int medium, int small) {
        MIN_CAP = small;
        MID_CAP = medium;
        BIG_CAP = big;
    }
    
    public boolean addCar(int carType) {
        switch(carType) {
            case 3:
                if(minCount == MIN_CAP) return false;
                minCount+=1;
                return true;
            case 2:
                if(midCount == MID_CAP) return false;
                midCount+=1;
                return true;
            case 1:
                if(bigCount == BIG_CAP) return false;
                bigCount+=1;
                return true;
        }
        
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */