package com.zonal.starwars.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.json.JSONObject;

import java.util.Objects;
import com.zonal.starwars.DaoSession;
import com.zonal.starwars.PlanetDao;

@Entity(active = true, generateConstructors = true, generateGettersSetters = true)
public class Planet implements Parcelable {
    @Id(autoincrement = true)
    private Long id;
    private String name;
    private String population;
    private String terrain;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String surface_water;


    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 547733003)
    private transient PlanetDao myDao;


    public Planet(String name, String population, String terrain, String rotation_period, String orbital_period, String diameter, String climate, String gravity, String surface_water){
        setName(name);
        setPopulation(population);
        setTerrain(terrain);
        setRotation_period(rotation_period);
        setOrbital_period(orbital_period);
        setDiameter(diameter);
        setClimate(climate);
        setGravity(gravity);
        setSurface_water(surface_water);

    }

    @Generated(hash = 1807367066)
    public Planet(Long id, String name, String population, String terrain, String rotation_period, String orbital_period, String diameter, String climate, String gravity, String surface_water) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.terrain = terrain;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.surface_water = surface_water;
    }

    @Generated(hash = 720757740)
    public Planet() {
    }

    protected Planet(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        name = in.readString();
        population = in.readString();
        terrain = in.readString();
        rotation_period = in.readString();
        orbital_period = in.readString();
        diameter = in.readString();
        climate = in.readString();
        gravity = in.readString();
        surface_water = in.readString();
    }

    public static final Creator<Planet> CREATOR = new Creator<Planet>() {
        @Override
        public Planet createFromParcel(Parcel in) {
            return new Planet(in);
        }

        @Override
        public Planet[] newArray(int size) {
            return new Planet[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(id, planet.id) && Objects.equals(name, planet.name) && Objects.equals(population, planet.population) && Objects.equals(daoSession, planet.daoSession) && Objects.equals(myDao, planet.myDao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, population, daoSession, myDao);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1300886363)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPlanetDao() : null;
    }

    public String getTerrain() {
        return this.terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getRotation_period() {
        return this.rotation_period;
    }

    public void setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
    }

    public String getOrbital_period() {
        return this.orbital_period;
    }

    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }

    public String getDiameter() {
        return this.diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return this.climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return this.gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getSurface_water() {
        return this.surface_water;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(name);
        parcel.writeString(population);
        parcel.writeString(terrain);
        parcel.writeString(rotation_period);
        parcel.writeString(orbital_period);
        parcel.writeString(diameter);
        parcel.writeString(climate);
        parcel.writeString(gravity);
        parcel.writeString(surface_water);
    }
}
