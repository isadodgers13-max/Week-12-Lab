package edu.cs3220.midterm.repository;

import edu.cs3220.midterm.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollRepository extends JpaRepository<Poll, Long> {}
---------------------------------------------------------------------
package edu.cs3220.midterm.repository;

import edu.cs3220.midterm.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {}
