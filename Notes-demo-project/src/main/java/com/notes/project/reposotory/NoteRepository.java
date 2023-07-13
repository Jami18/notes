package com.notes.project.reposotory;

import com.notes.project.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Notes, Long> {
}
