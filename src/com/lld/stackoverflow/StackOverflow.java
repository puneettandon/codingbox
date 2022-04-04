package com.lld.stackoverflow;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class StackOverflow {
    public static void main(String[] args) {

    }
}

abstract class User{
    int guestId;
   // Search searchObj;

    public abstract List<Question> getQuestions(String searchString);
}

abstract class Member extends  User{

    Account account;
    List<Badge> badges;

    public abstract void addQuestion(Question question);
    public abstract void addComment(Entity entity,Comment comment);
    public abstract void addAnswer(Question question,Answer answer);
    public abstract void vote(Entity entity,VoteType voteType);
    public abstract void addTag(Question question,Tag tag);
    public abstract void flag(Entity entity);
    public abstract List<Badge> getBadges();
}


class Account{

    String name;
    String address;
    int accountId;
    String userName;
    String password;
    String email;

    AccountStatus accountStatus;
    int reputation;
}

abstract class Moderator extends Member{

    public abstract Boolean closeQuestion(Question question);
    public abstract Boolean restoreQuestion(Question question);
}

abstract class Admin extends  Member{

    public abstract Boolean blockMember(Member member);
    public abstract Boolean unlockMember(Member member);
}

enum AccountStatus{

    BLOCKED,ACTIVE,CLOSED
}

enum VoteType{
    UPVOTE,DOWNTYPE,CLOSEVOTE,DELETEVOTE
}

class Badge{
    String name;
    String description;
}

abstract class Entity{
    int entityId;
    Member creator;
    Map<VoteType,Integer> votes;
    Date createdDate;
    List<Comment> comments;

    public abstract Boolean flagEntity(Member member);
    public abstract Boolean voteEntity(VoteType voteType);
    public abstract Boolean addComment(Comment comment);
}

abstract class Comment extends Entity{
    String message;
}

abstract class Question extends Entity{

    List<EditHistory> editHistory;
    List<Answer> answerList;
    List<Tag> tags;
    String title;
    String description;
    QuestionStatus questionStatus;

    public abstract boolean addQuestion();
    public abstract boolean addTag(Tag tag);

}

abstract class Answer extends Entity{
    String answer;
    Boolean isAccepted;

    public abstract boolean addAnswer(Question question);
}

enum QuestionStatus{
    ACTIVE,BOUNTED,CLOSED,FLAGGED
}

class Tag{
    String name;
    String description;
}

class EditHistory{
    int editHistoryId;
    Member creator;
    Date creationDate;
    Question prevQuestion;
    Question updatedQuestion;
}
