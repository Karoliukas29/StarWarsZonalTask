package com.zonal.starwars;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.zonal.starwars.model.Planet;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PLANET".
*/
public class PlanetDao extends AbstractDao<Planet, Long> {

    public static final String TABLENAME = "PLANET";

    /**
     * Properties of entity Planet.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Population = new Property(2, String.class, "population", false, "POPULATION");
        public final static Property Terrain = new Property(3, String.class, "terrain", false, "TERRAIN");
        public final static Property Rotation_period = new Property(4, String.class, "rotation_period", false, "ROTATION_PERIOD");
        public final static Property Orbital_period = new Property(5, String.class, "orbital_period", false, "ORBITAL_PERIOD");
        public final static Property Diameter = new Property(6, String.class, "diameter", false, "DIAMETER");
        public final static Property Climate = new Property(7, String.class, "climate", false, "CLIMATE");
        public final static Property Gravity = new Property(8, String.class, "gravity", false, "GRAVITY");
        public final static Property Surface_water = new Property(9, String.class, "surface_water", false, "SURFACE_WATER");
    }

    private DaoSession daoSession;


    public PlanetDao(DaoConfig config) {
        super(config);
    }
    
    public PlanetDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PLANET\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"POPULATION\" TEXT," + // 2: population
                "\"TERRAIN\" TEXT," + // 3: terrain
                "\"ROTATION_PERIOD\" TEXT," + // 4: rotation_period
                "\"ORBITAL_PERIOD\" TEXT," + // 5: orbital_period
                "\"DIAMETER\" TEXT," + // 6: diameter
                "\"CLIMATE\" TEXT," + // 7: climate
                "\"GRAVITY\" TEXT," + // 8: gravity
                "\"SURFACE_WATER\" TEXT);"); // 9: surface_water
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PLANET\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Planet entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String population = entity.getPopulation();
        if (population != null) {
            stmt.bindString(3, population);
        }
 
        String terrain = entity.getTerrain();
        if (terrain != null) {
            stmt.bindString(4, terrain);
        }
 
        String rotation_period = entity.getRotation_period();
        if (rotation_period != null) {
            stmt.bindString(5, rotation_period);
        }
 
        String orbital_period = entity.getOrbital_period();
        if (orbital_period != null) {
            stmt.bindString(6, orbital_period);
        }
 
        String diameter = entity.getDiameter();
        if (diameter != null) {
            stmt.bindString(7, diameter);
        }
 
        String climate = entity.getClimate();
        if (climate != null) {
            stmt.bindString(8, climate);
        }
 
        String gravity = entity.getGravity();
        if (gravity != null) {
            stmt.bindString(9, gravity);
        }
 
        String surface_water = entity.getSurface_water();
        if (surface_water != null) {
            stmt.bindString(10, surface_water);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Planet entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String population = entity.getPopulation();
        if (population != null) {
            stmt.bindString(3, population);
        }
 
        String terrain = entity.getTerrain();
        if (terrain != null) {
            stmt.bindString(4, terrain);
        }
 
        String rotation_period = entity.getRotation_period();
        if (rotation_period != null) {
            stmt.bindString(5, rotation_period);
        }
 
        String orbital_period = entity.getOrbital_period();
        if (orbital_period != null) {
            stmt.bindString(6, orbital_period);
        }
 
        String diameter = entity.getDiameter();
        if (diameter != null) {
            stmt.bindString(7, diameter);
        }
 
        String climate = entity.getClimate();
        if (climate != null) {
            stmt.bindString(8, climate);
        }
 
        String gravity = entity.getGravity();
        if (gravity != null) {
            stmt.bindString(9, gravity);
        }
 
        String surface_water = entity.getSurface_water();
        if (surface_water != null) {
            stmt.bindString(10, surface_water);
        }
    }

    @Override
    protected final void attachEntity(Planet entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Planet readEntity(Cursor cursor, int offset) {
        Planet entity = new Planet( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // population
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // terrain
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // rotation_period
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // orbital_period
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // diameter
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // climate
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // gravity
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // surface_water
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Planet entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPopulation(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTerrain(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setRotation_period(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setOrbital_period(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setDiameter(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setClimate(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setGravity(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setSurface_water(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Planet entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Planet entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Planet entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
