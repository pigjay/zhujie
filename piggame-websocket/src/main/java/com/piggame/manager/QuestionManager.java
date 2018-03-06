package com.piggame.manager;

import com.piggame.entity.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author:zhujie
 * @Date: Create in 14:33 2018/3/6
 **/
public class QuestionManager {

    private final static List<Question> questions = new ArrayList<Question>();

    static {
        questions.add(new Question("成语","天人合一"));
        questions.add(new Question("成语","五体投地"));
        questions.add(new Question("成语","亡羊补牢"));
        questions.add(new Question("成语","掩耳盗铃"));
        questions.add(new Question("成语","一寸光阴一寸金"));
        questions.add(new Question("职业","教师"));
        questions.add(new Question("职业","学生"));
        questions.add(new Question("职业","程序员"));
        questions.add(new Question("职业","歌手"));
        questions.add(new Question("职业","训兽师"));
        questions.add(new Question("职业","模特"));
        questions.add(new Question("职业","演员"));
        questions.add(new Question("动物","老鼠"));
        questions.add(new Question("动物","老虎"));
        questions.add(new Question("动物","蟑螂"));
        questions.add(new Question("动物","蚂蚁"));
        questions.add(new Question("动物","老鹰"));
        questions.add(new Question("动物","蟒蛇"));
        questions.add(new Question("动物","兔子"));
        questions.add(new Question("动漫人物","蜡笔小新"));
        questions.add(new Question("动漫人物","奥特曼"));
        questions.add(new Question("动漫人物","蜡笔小新"));
        questions.add(new Question("动漫人物","葫芦娃"));
        questions.add(new Question("动漫人物","超人"));
        questions.add(new Question("动漫人物","钢铁侠"));
        questions.add(new Question("动漫人物","孙悟空"));
        questions.add(new Question("动漫人物","铁臂阿童木"));
    }

    /**
     * 获取题目
     * @param num
     * @return
     */
    public static List<Question> getQuestions(int num){
        List<Question> questions1 = new ArrayList<Question>(num);
        List<Integer> ids = new ArrayList<Integer>(num);
        Random random = new Random();
        while (true){
            int id = random.nextInt(questions.size());
            if(!ids.contains(id)){
                ids.add(id);
                questions1.add(questions.get(id));
                if (questions1.size() == num){
                    return questions1;
                }
            }
        }
    }

}
