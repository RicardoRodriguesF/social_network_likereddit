package org.ricardorodrigues.socialnetwork.repository;

import org.ricardorodrigues.socialnetwork.model.Post;
import org.ricardorodrigues.socialnetwork.model.User;
import org.ricardorodrigues.socialnetwork.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}

