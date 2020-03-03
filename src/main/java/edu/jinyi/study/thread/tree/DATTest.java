package edu.jinyi.study.thread.tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <link>http://www.hankcs.com/program/java/%E5%8F%8C%E6%95%B0%E7%BB%84trie%E6%A0%91doublearraytriejava%E5%AE%9E%E7%8E%B0.html</>
 * @author liujin
 * @date 2019/11/6
 * @since JDK8
 */
public class DATTest {
  public static void main(String[] args) throws IOException
  {
    BufferedReader reader = new BufferedReader(new FileReader("E:\\workspace\\gitlab-project\\design-pattern\\src\\main\\resources\\data\\small.dic"));
    String line;
    List<String> words = new ArrayList<String>();
    Set<Character> charset = new HashSet<Character>();
    while ((line = reader.readLine()) != null)
    {
      words.add(line);
      // 制作一份码表debug
      for (char c : line.toCharArray())
      {
        charset.add(c);
      }
    }
    reader.close();
    // 这个字典如果要加入新词必须按字典序，参考下面的代码
//        Collections.sort(words);
//        BufferedWriter writer = new BufferedWriter(new FileWriter("./data/sorted.dic", false));
//        for (String w : words)
//        {
//            writer.write(w);
//            writer.newLine();
//        }
    System.out.println("字典词条：" + words.size());

    {
      String infoCharsetValue = "";
      String infoCharsetCode = "";
      for (Character c : charset)
      {
        infoCharsetValue += c.charValue() + "    ";
        infoCharsetCode += (int)c.charValue() + " ";
      }
      infoCharsetValue += '\n';
      infoCharsetCode += '\n';
      System.out.print(infoCharsetValue);
      System.out.print(infoCharsetCode);
    }

    DoubleArrayTrie dat = new DoubleArrayTrie();
    System.out.println("是否错误: " + dat.build(words));
    System.out.println(dat);
    List<Integer> integerList = dat.commonPrefixSearch("一举成名天下知道");
    for (int index : integerList)
    {
      System.out.println(words.get(index));
    }
  }
}
