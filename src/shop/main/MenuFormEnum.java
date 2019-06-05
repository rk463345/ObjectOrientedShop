package shop.main;

public enum MenuFormEnum {
		START {
			int next() {
				return 2;
			}
		},
		EXIT{
			int next() {
				return 1;
			}
		},
		EXITED{
			int next() {
				return 0;
			}
		};
	abstract int next();
}
