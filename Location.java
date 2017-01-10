package TstingJunit;

	public class Location {

		private long x;
		private long y;
		
		public Location(long x, long y) {
			// TODO Auto-generated constructor stub
			super();
			this.x = x;
			this.y = y;
			
		}
		public long getDistance(Location other) {
			return (long) Math.sqrt(Math.pow((this.x - 	other.x), 2) + Math.pow(this.y - other.y, 2));
		}
		public long getX() {
			// TODO Auto-generated method stub
			return x;
		}
		public long getY() {
			// TODO Auto-generated method stub
			return y;
		}

}
