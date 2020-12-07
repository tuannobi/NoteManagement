package com.tuno.dao;

import com.tuno.base.BaseDaoImpl;
import com.tuno.model.Note;
import com.tuno.util.Constant;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDaoImpl extends BaseDaoImpl<Note, Long> implements NoteDao {
    @Override
    public String getHibernateTableName() {
        return Note.class.getSimpleName();
    }

    @Override
    public String getHibernateKeyName() {
        return Constant.HibernateKeyName.noteId.toString();
    }
}
