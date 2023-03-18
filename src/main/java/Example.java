import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class Example {
    public int run(String begin, String target, String[] words) {
        int answer = words.length;

        Set<String> visited = new HashSet<>();
        Queue<Word> q = new LinkedList<>();
        visited.add(begin);
        Word firstWord = new Word();
        firstWord.word = begin;
        firstWord.count = 0;
        q.add(firstWord);

        while (!q.isEmpty()) {
            Word current = q.poll();

            if (current.word.equals(target)) {
                answer = Math.min(answer, current.count);
            }

            for (String w : words) {
                if (visited.contains(w) || current.word.equals(w)) {
                    continue;
                }

                int diff = 0;
                for (int si = 0; si < current.word.length(); si++) {
                    if (w.charAt(si) != current.word.charAt(si)) {
                        diff++;
                    }

                    if (diff > 1) {
                        break;
                    }
                }

                if (diff == 1) {
                    Word newWord = new Word();
                    newWord.word = w;
                    newWord.count = current.count + 1;
                    q.add(newWord);
                    visited.add(w);
                }
            }
        }

        return answer >= words.length ? 0 : answer ;
    }

    static class Word {
        String word;
        int count;
    }
}