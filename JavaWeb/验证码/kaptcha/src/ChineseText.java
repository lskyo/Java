import java.util.Random;

import com.google.code.kaptcha.text.TextProducer;
import com.google.code.kaptcha.util.Configurable;

public class ChineseText extends Configurable implements TextProducer {

	public String getText() {
		int length = getConfig().getTextProducerCharLength();
		//char[] charS = getConfig().getTextProducerCharString();
		
		String[] s = new String[]{"零","一","二","三","四","五","六","七","八","九"};

		Random rand = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < length; i++){
			int ind = rand.nextInt(s.length);
			sb.append(s[ind]);
		}
		return sb.toString();
	}
	/**
	 * 中午实例
	 * @return
	 */
	public String getText1() {
		int length = getConfig().getTextProducerCharLength();
		String finalWord = "", firstWord = "";
		int tempInt = 0;
		String[] array = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"a", "b", "c", "d", "e", "f" };

		Random rand = new Random();

		for (int i = 0; i < length; i++) {
			switch (rand.nextInt(array.length)) {
			case 1:
				tempInt = rand.nextInt(26) + 65;
				firstWord = String.valueOf((char) tempInt);
				break;
			case 2:
				int r1,
				r2,
				r3,
				r4;
				String strH,
				strL;// high&low
				r1 = rand.nextInt(3) + 11; // 前闭后开[11,14)
				if (r1 == 13) {
					r2 = rand.nextInt(7);
				} else {
					r2 = rand.nextInt(16);
				}

				r3 = rand.nextInt(6) + 10;
				if (r3 == 10) {
					r4 = rand.nextInt(15) + 1;
				} else if (r3 == 15) {
					r4 = rand.nextInt(15);
				} else {
					r4 = rand.nextInt(16);
				}

				strH = array[r1] + array[r2];
				strL = array[r3] + array[r4];

				byte[] bytes = new byte[2];
				bytes[0] = (byte) (Integer.parseInt(strH, 16));
				bytes[1] = (byte) (Integer.parseInt(strL, 16));

				firstWord = new String(bytes);
				break;
			default:
				tempInt = rand.nextInt(10) + 48;
				firstWord = String.valueOf((char) tempInt);
				break;
			}
			finalWord += firstWord;
		}
		return finalWord;
	}
}