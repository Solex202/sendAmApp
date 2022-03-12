package africa.semicolon.sendAm.data.repositories;

import africa.semicolon.sendAm.data.models.Package;

import java.util.ArrayList;
import java.util.List;

public class PackageRepositoryImpl implements PackageRepository{

    private List<Package> db = new ArrayList<>();
    private int id = 0;
    @Override
    public Package save(Package aPackage) {
        if(aPackage.getId() == 0){
            saveNew(aPackage);
        }else {
            update(aPackage);
        }

        return aPackage;
        //return db.get( --id);
    }

    private Package update(Package aPackage) {
        delete(aPackage.getId());
        db.add(aPackage);
        return aPackage;
    }

    private void saveNew(Package aPackage){
        int id = generateId();
        aPackage.setId(id);
        db.add(aPackage);
    }

    private int generateId() {
        id = id + 1;
        return id;
//        int id = ++this.id;
//        return id;
        //return db.size() + 1;
    }

    @Override
    public Package findById(int id) {
        for(Package aPackage : db){
            if(aPackage.getId() == id)
                return aPackage;
        }
        return null;
    }

    @Override
    public void delete(Package aPackage) {
        db.remove(aPackage);
    }

    @Override
    public void delete(int id) {
        Package foundPackage = findById(id);
        delete(foundPackage);
        //db.remove(foundPackage);
    }

    @Override
    public List<Package> findAll() {
        return db;
    }

    @Override
    public int count() {
        return db.size();
    }

}
