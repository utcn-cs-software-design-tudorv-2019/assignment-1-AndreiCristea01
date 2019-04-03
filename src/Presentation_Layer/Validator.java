package Presentation_Layer;

public class Validator {

	public boolean cnp_valid(String s) {

		if (s.length() > 13 || s.length() < 13)
			return false;

		return true;
	}

	public boolean grade_valid(int g) {

		if (g < 0 || g > 10)
			return false;

		return true;
	}
}
