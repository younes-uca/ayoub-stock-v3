package  ma.zs.stocky.dao.criteria.core.gestionchequeffet;


import ma.zs.stocky.dao.criteria.core.commun.DepotCriteria;
import ma.zs.stocky.dao.criteria.core.stock.ProduitCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class PermutationItemCriteria extends  BaseCriteria  {

    private String quantite;
    private String quantiteMin;
    private String quantiteMax;

    private ProduitCriteria produit ;
    private List<ProduitCriteria> produits ;
    private DepotCriteria depot ;
    private List<DepotCriteria> depots ;
    private PermutationCriteria permutation ;
    private List<PermutationCriteria> permutations ;


    public PermutationItemCriteria(){}

    public String getQuantite(){
        return this.quantite;
    }
    public void setQuantite(String quantite){
        this.quantite = quantite;
    }   
    public String getQuantiteMin(){
        return this.quantiteMin;
    }
    public void setQuantiteMin(String quantiteMin){
        this.quantiteMin = quantiteMin;
    }
    public String getQuantiteMax(){
        return this.quantiteMax;
    }
    public void setQuantiteMax(String quantiteMax){
        this.quantiteMax = quantiteMax;
    }
      

    public ProduitCriteria getProduit(){
        return this.produit;
    }

    public void setProduit(ProduitCriteria produit){
        this.produit = produit;
    }
    public List<ProduitCriteria> getProduits(){
        return this.produits;
    }

    public void setProduits(List<ProduitCriteria> produits){
        this.produits = produits;
    }
    public DepotCriteria getDepot(){
        return this.depot;
    }

    public void setDepot(DepotCriteria depot){
        this.depot = depot;
    }
    public List<DepotCriteria> getDepots(){
        return this.depots;
    }

    public void setDepots(List<DepotCriteria> depots){
        this.depots = depots;
    }
    public PermutationCriteria getPermutation(){
        return this.permutation;
    }

    public void setPermutation(PermutationCriteria permutation){
        this.permutation = permutation;
    }
    public List<PermutationCriteria> getPermutations(){
        return this.permutations;
    }

    public void setPermutations(List<PermutationCriteria> permutations){
        this.permutations = permutations;
    }
}
