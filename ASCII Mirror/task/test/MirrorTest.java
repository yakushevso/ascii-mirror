import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.exception.outcomes.WrongAnswer;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testing.TestedProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MirrorTest extends StageTest {
  @DynamicTest
  CheckResult test() {
    TestedProgram pr = new TestedProgram();
    String output = pr.start();
    String[] strings = output.split("\n");
    List<String> list = new ArrayList<>(Arrays.asList(strings));
    list.removeAll(Arrays.asList(""));
    if(list.size()!=8){
      throw new WrongAnswer("There should be printed exactly 8 lines, containing cow's picture");
    }
    List<String> correctList = new ArrayList<>(Arrays.asList(
            "                    _______ ",
            "                   < hello >",
            "                    ------- ",
            "            ^__^   /        ",
            "    _______/(oo)  /         ",
            "/\\/(       /(__)            ",
            "   | w----||                ",
            "   ||     ||                "));
    for (int i=0;i<list.size();i++){
      if(!list.get(i).equals(correctList.get(i))){
        throw new WrongAnswer("All the printed lines should be equal to lines in the example. " +
                "Make sure, that you've not ignored whitespaces at the beginning and at the end of each line");
      }
    }
    if(!pr.isFinished()){
      throw new WrongAnswer("Program should finish after outputting the picture");
    }
    return CheckResult.correct();
  }
}