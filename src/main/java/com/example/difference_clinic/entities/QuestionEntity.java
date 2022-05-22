package com.example.difference_clinic.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "question")
public class QuestionEntity {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String questionText;
    private String answer;
    private boolean common;
    @JsonIgnoreProperties(value = {"question"},allowSetters = true)
    @ManyToOne(targetEntity = User.class)
    private User user;


    public QuestionEntity() {
    }

    public QuestionEntity(Long id, String questionText, String answer, boolean common, User user) {
        this.id = id;
        this.questionText = questionText;
        this.answer = answer;
        this.common = common;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCommon() {
        return this.common;
    }

    public boolean getCommon() {
        return this.common;
    }

    public void setCommon(boolean common) {
        this.common = common;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public QuestionEntity id(Long id) {
        setId(id);
        return this;
    }

    public QuestionEntity questionText(String questionText) {
        setQuestionText(questionText);
        return this;
    }

    public QuestionEntity answer(String answer) {
        setAnswer(answer);
        return this;
    }

    public QuestionEntity common(boolean common) {
        setCommon(common);
        return this;
    }

    public QuestionEntity user(User user) {
        setUser(user);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof QuestionEntity)) {
            return false;
        }
        QuestionEntity questionEntity = (QuestionEntity) o;
        return Objects.equals(id, questionEntity.id) && Objects.equals(questionText, questionEntity.questionText) && Objects.equals(answer, questionEntity.answer) && common == questionEntity.common && Objects.equals(user, questionEntity.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionText, answer, common, user);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", questionText='" + getQuestionText() + "'" +
            ", answer='" + getAnswer() + "'" +
            ", common='" + isCommon() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }
   
}
