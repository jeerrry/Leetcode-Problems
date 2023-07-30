class AverageLog {
    public long averageTime;
    public long totalTravels;
    
    public AverageLog(int diff) {
        updateAverage(diff);
    }
    
    public void updateAverage(int diff) {
        averageTime += diff;
        totalTravels += 1;
    }
    
    public double getAverageTime() {
        if (totalTravels == 0) return 0;
        return (averageTime * 1.0)/totalTravels;
    }
}

class CustomerLog {
    public Travel travel;
    public int startTime;
    public int endTime;
    
    public CustomerLog(String stationName, int startTime) {
        this.travel = new Travel();
        this.travel.origin = stationName;
        this.startTime = startTime;
    }
    
    public void checkoutCustomer(String stationName, int endTime) {
        this.travel.destination = stationName;
        this.endTime = endTime;
    }
    
    public int getTravelDuration() {
        return endTime - startTime;
    }
}

class Travel {
    public String origin;
    public String destination;
    
    public String toString() {
        return origin + "->" + destination;
    }
}

class UndergroundSystem {
    private final HashMap<Integer, CustomerLog> customerLogs;
    private final HashMap<String, AverageLog> averageLogs;
    
    public UndergroundSystem() {
        customerLogs = new HashMap<>();
        averageLogs = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if(customerLogs.containsKey(id)) return;
        
        var log = new CustomerLog(stationName, t);
        customerLogs.put(id, log);
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(!customerLogs.containsKey(id)) return;
        
        var log = customerLogs.get(id);
        log.checkoutCustomer(stationName, t);
        
        customerLogs.remove(id);
        
        if(averageLogs.containsKey(log.travel.toString())) {
            var avgLog = averageLogs.get(log.travel.toString());
            avgLog.updateAverage(log.getTravelDuration());
        }else{
            var temp = new AverageLog(log.getTravelDuration());
            averageLogs.put(log.travel.toString(), temp);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        if(!averageLogs.containsKey(key)) return 0;
        
        var result = averageLogs.get(key);
        return result.getAverageTime();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */