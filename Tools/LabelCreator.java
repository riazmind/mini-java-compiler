package Tools;

public class LabelCreator {

	private String preface = "";
	private static int ifCount = 0;
	private static int whileCount = 0;
	private static int elseCount = 0;
	private static int bodyCount = 0;
	private static int customCount = 0;
	private static LabelCreator instance = null;
	private static String custom;

	private LabelCreator() {
		String os = System.getProperty("os.name");
		if (os.contains("Windows") ||
			os.contains("OS X")) 
		{
			preface = "_";
		}
	}

	public static LabelCreator getInstance() {
		if (instance ==  null)
			return new LabelCreator();
		else
			return instance;
	}

	public String getPreface() {
		return preface;
	}

	public String getCallName(String cn, String fn) {
		if (cn.equals("")) {
			return preface + fn;
		} else {
			return preface + cn + "$" + fn;
		}
	}

	public String getLabel(String cn, String fn) {
		if (cn.equals("")) {
			return preface + fn + ":";
		} else {
			return preface + cn + "$" + fn + ":";
		}
	}

	public String getCustomLabel(String s) {
		custom = s;
		customCount += 1;
		return preface + custom + String.valueOf(customCount) + ":";
	}

	public String getIfLabel() {
		ifCount += 1;
		return preface +"IF"+ String.valueOf(ifCount) + ":";
	}

	public String getWhileLabel() {
		whileCount += 1;
		return preface +"WHILE"+ String.valueOf(whileCount) + ":";
	}

	public String getElseLabel() {
		elseCount += 1;
		return preface +"ELSE"+ String.valueOf(elseCount) + ":";
	}

	public String getBodyLabel() {
		bodyCount += 1;
		return preface +"BODY"+ String.valueOf(bodyCount) + ":";
	}

	public String getIfName() {
		return preface +"IF"+ String.valueOf(ifCount);
	}

	public String getWhileName() {
		return preface +"WHILE"+ String.valueOf(whileCount);
	}

	public String getElseName() {
		return preface +"ELSE"+ String.valueOf(elseCount);
	}

	public String getBodyName() {
		return preface +"BODY"+ String.valueOf(bodyCount);
	}

	public String getCustomName() {
		return preface + custom + String.valueOf(customCount);
	}
}
