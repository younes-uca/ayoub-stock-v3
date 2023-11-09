package  ma.zs.stocky.dao.criteria.core.commun;



import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class VilleCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;



    public VilleCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }


}
