package geotest1;

public class Geocode1 {

	public static void main(String[] args) {
		String location = "대전광역시 유성구 궁동";
		Float[] coords = Geocode.findGeoPoint(location);

		System.out.println(location + ": " + coords[0] + ", " + coords[1]);
	}

}
