public class Park {
    public String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        public String attractionName;
        public String workingHours;
        public int cost;

        public Attraction(String attractionName, String workingHours, int cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void printAttractionInfo() {
            System.out.println("Парк: " + parkName);
            System.out.println("  Аттракцион: " + attractionName);
            System.out.println("  Время работы: " + workingHours);
            System.out.println("  Стоимость: " + cost + " руб.");
            System.out.println("----------------------------------------------");
        }
    }
}