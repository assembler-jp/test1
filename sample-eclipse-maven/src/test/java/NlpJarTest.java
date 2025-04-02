import jp.co.extreme.base.core.*;
import jp.co.extreme.base.log.*;
import jp.co.extreme.base.log.BcLogConstants.*;
import jp.co.extreme.lib.nlp.*;


/**
 * NlpJarTest
 *
 * @version 1.00
 * @since
 * @author 
 */
public class NlpJarTest extends Object {

  /** test1 */
  public void test1() throws Exception {
    BcLogger logger = BcLogUtil.getDefaultLogger();
    String src = "山田太郎、、、大谷 翔平、今田耕司、関屋敏子、菅英三子、飯島千雍子.mp4 東京駅 礪波護 蔀 勇造、      劉傑"
        + BcUnicode.FULLWIDTH_SPACE_STR+BcUnicode.FULLWIDTH_SPACE_STR
        + "大友 良英 - 中原昌也 彌勒 忠史 嘉納 愛子"
        + "根室市 函館 市 秋田 県 千葉 県 埼玉県 富良野市 山田太郎 がホームランを打ちました。"
        + "、一審、中文、市緑、市港、万円、時前、機制、赤羽、市中 Haley Reed"
        + " 野田江川富士一二三四五左衛門助太郎" 
        ;

    NlpBuilder nlpBuilder = new NlpBuilder();
    NlpNounFinderImpl nounFinder = nlpBuilder.boild();

    NlpResult nlpResult = nounFinder.find(src);
    NlpPersonNameUtil.dispResult(nlpResult);
 }


  /** main */
  public static void main(String[] args) {
    BcLogger logger = BcLogUtil.getDefaultLogger();
    logger.setLogLevel(LogLevel.DEBUG);
    try {

      NlpJarTest instance = new NlpJarTest();
      instance.test1(); 

      System.out.println("finished.");
  	} catch (Exception ex) {
      BcLogUtil.error(ex);
    }
    System.exit(0);
  }

}
