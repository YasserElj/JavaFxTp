package ma.enset.tpjdbc.services;

import ma.enset.tpjdbc.dao.*;
import ma.enset.tpjdbc.dao.entities.*;

import java.util.List;

public class CatalogueServiceImpl implements ma.enset.tpjdbc.services.CatalogueService {
    ProduitDaoImpl produitDao;
    CategorieDaoImpl categorieDao;


    public CatalogueServiceImpl() {
    }



    public ProduitDaoImpl getProduitDao() {
        return produitDao;
    }

    public void setProduitDao(ProduitDaoImpl produitDao) {
        this.produitDao = produitDao;
    }

    public CategorieDaoImpl getCategorieDao() {
        return categorieDao;
    }

    public void setCategorieDao(CategorieDaoImpl categorieDao) {
        this.categorieDao = categorieDao;
    }


    public CatalogueServiceImpl(ProduitDaoImpl produitDao, CategorieDaoImpl categorieDao) {
        this.produitDao = produitDao;
        this.categorieDao = categorieDao;
    }

    @Override
    public List<Produit> getAllProducts() {
        return produitDao.findAll();
    }

    @Override
    public boolean addProduct(Produit p) {
        return produitDao.add(p);
    }

    @Override
    public boolean removeProduct(int id) {
        return produitDao.remove(id);
    }

    @Override
    public Produit findProduct(int id) {
        return produitDao.findById(id);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieDao.findAll();
    }

    @Override
    public boolean addCategorie(Categorie p) {
        return categorieDao.add(p);
    }

    @Override
    public boolean removeCategorie(int id) {
        return categorieDao.remove(id);
    }

    @Override
    public Categorie findCategorie(int id) {
        return categorieDao.findById(id);
    }

   }
