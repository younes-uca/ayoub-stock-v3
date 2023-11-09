package ma.zs.stocky;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.cache.annotation.EnableCaching;
import com.fasterxml.jackson.databind.SerializationFeature;


import ma.zs.stocky.zynerator.security.common.AuthoritiesConstants;
import ma.zs.stocky.zynerator.security.bean.User;
import ma.zs.stocky.zynerator.security.bean.Permission;
import ma.zs.stocky.zynerator.security.bean.Role;
import ma.zs.stocky.zynerator.security.service.facade.UserService;
import ma.zs.stocky.zynerator.security.service.facade.RoleService;

//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
//@EnableElasticsearchRepositories("ma.zs.stocky.dao")
//@EnableFeignClients("ma.zs.stocky.required.facade")
public class StockyApplication {
    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) {
        ctx=SpringApplication.run(StockyApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    ObjectMapper objectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
    return (args) -> {
        if(true){



    // Role admin

        User userForAdmin = new User("admin");

        Role roleForAdmin = new Role();
        roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
        List<Permission> permissionsForAdmin = new ArrayList<>();
        addPermissionForAdmin(permissionsForAdmin);
        roleForAdmin.setPermissions(permissionsForAdmin);
        if(userForAdmin.getRoles()==null)
            userForAdmin.setRoles(new ArrayList<>());

        userForAdmin.getRoles().add(roleForAdmin);
        userService.save(userForAdmin);
            }
        };
    }




    private static String fakeString(String attributeName, int i) {
        return attributeName + i;
    }

    private static Long fakeLong(String attributeName, int i) {
        return  10L * i;
    }
    private static Integer fakeInteger(String attributeName, int i) {
        return  10 * i;
    }

    private static Double fakeDouble(String attributeName, int i) {
        return 10D * i;
    }

    private static BigDecimal fakeBigDecimal(String attributeName, int i) {
        return  BigDecimal.valueOf(i*1L*10);
    }

    private static Boolean fakeBoolean(String attributeName, int i) {
        return i % 2 == 0 ? true : false;
    }
    private static LocalDateTime fakeLocalDateTime(String attributeName, int i) {
        return LocalDateTime.now().plusDays(i);
    }
    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("Collaborateur.edit"));
        permissions.add(new Permission("Collaborateur.list"));
        permissions.add(new Permission("Collaborateur.view"));
        permissions.add(new Permission("Collaborateur.add"));
        permissions.add(new Permission("Collaborateur.delete"));
        permissions.add(new Permission("ModePaiement.edit"));
        permissions.add(new Permission("ModePaiement.list"));
        permissions.add(new Permission("ModePaiement.view"));
        permissions.add(new Permission("ModePaiement.add"));
        permissions.add(new Permission("ModePaiement.delete"));
        permissions.add(new Permission("AvoirVenteItem.edit"));
        permissions.add(new Permission("AvoirVenteItem.list"));
        permissions.add(new Permission("AvoirVenteItem.view"));
        permissions.add(new Permission("AvoirVenteItem.add"));
        permissions.add(new Permission("AvoirVenteItem.delete"));
        permissions.add(new Permission("Fournisseur.edit"));
        permissions.add(new Permission("Fournisseur.list"));
        permissions.add(new Permission("Fournisseur.view"));
        permissions.add(new Permission("Fournisseur.add"));
        permissions.add(new Permission("Fournisseur.delete"));
        permissions.add(new Permission("AvoirVente.edit"));
        permissions.add(new Permission("AvoirVente.list"));
        permissions.add(new Permission("AvoirVente.view"));
        permissions.add(new Permission("AvoirVente.add"));
        permissions.add(new Permission("AvoirVente.delete"));
        permissions.add(new Permission("Proprietaire.edit"));
        permissions.add(new Permission("Proprietaire.list"));
        permissions.add(new Permission("Proprietaire.view"));
        permissions.add(new Permission("Proprietaire.add"));
        permissions.add(new Permission("Proprietaire.delete"));
        permissions.add(new Permission("ProprietaireBanque.edit"));
        permissions.add(new Permission("ProprietaireBanque.list"));
        permissions.add(new Permission("ProprietaireBanque.view"));
        permissions.add(new Permission("ProprietaireBanque.add"));
        permissions.add(new Permission("ProprietaireBanque.delete"));
        permissions.add(new Permission("EntreeProduit.edit"));
        permissions.add(new Permission("EntreeProduit.list"));
        permissions.add(new Permission("EntreeProduit.view"));
        permissions.add(new Permission("EntreeProduit.add"));
        permissions.add(new Permission("EntreeProduit.delete"));
        permissions.add(new Permission("AchatItem.edit"));
        permissions.add(new Permission("AchatItem.list"));
        permissions.add(new Permission("AchatItem.view"));
        permissions.add(new Permission("AchatItem.add"));
        permissions.add(new Permission("AchatItem.delete"));
        permissions.add(new Permission("Categorie.edit"));
        permissions.add(new Permission("Categorie.list"));
        permissions.add(new Permission("Categorie.view"));
        permissions.add(new Permission("Categorie.add"));
        permissions.add(new Permission("Categorie.delete"));
        permissions.add(new Permission("PaiementAvoirAchat.edit"));
        permissions.add(new Permission("PaiementAvoirAchat.list"));
        permissions.add(new Permission("PaiementAvoirAchat.view"));
        permissions.add(new Permission("PaiementAvoirAchat.add"));
        permissions.add(new Permission("PaiementAvoirAchat.delete"));
        permissions.add(new Permission("Transaction.edit"));
        permissions.add(new Permission("Transaction.list"));
        permissions.add(new Permission("Transaction.view"));
        permissions.add(new Permission("Transaction.add"));
        permissions.add(new Permission("Transaction.delete"));
        permissions.add(new Permission("Instrument.edit"));
        permissions.add(new Permission("Instrument.list"));
        permissions.add(new Permission("Instrument.view"));
        permissions.add(new Permission("Instrument.add"));
        permissions.add(new Permission("Instrument.delete"));
        permissions.add(new Permission("Achat.edit"));
        permissions.add(new Permission("Achat.list"));
        permissions.add(new Permission("Achat.view"));
        permissions.add(new Permission("Achat.add"));
        permissions.add(new Permission("Achat.delete"));
        permissions.add(new Permission("PaiementAvoirVente.edit"));
        permissions.add(new Permission("PaiementAvoirVente.list"));
        permissions.add(new Permission("PaiementAvoirVente.view"));
        permissions.add(new Permission("PaiementAvoirVente.add"));
        permissions.add(new Permission("PaiementAvoirVente.delete"));
        permissions.add(new Permission("AvoirAchatItem.edit"));
        permissions.add(new Permission("AvoirAchatItem.list"));
        permissions.add(new Permission("AvoirAchatItem.view"));
        permissions.add(new Permission("AvoirAchatItem.add"));
        permissions.add(new Permission("AvoirAchatItem.delete"));
        permissions.add(new Permission("Depense.edit"));
        permissions.add(new Permission("Depense.list"));
        permissions.add(new Permission("Depense.view"));
        permissions.add(new Permission("Depense.add"));
        permissions.add(new Permission("Depense.delete"));
        permissions.add(new Permission("Depot.edit"));
        permissions.add(new Permission("Depot.list"));
        permissions.add(new Permission("Depot.view"));
        permissions.add(new Permission("Depot.add"));
        permissions.add(new Permission("Depot.delete"));
        permissions.add(new Permission("SortieProduitItem.edit"));
        permissions.add(new Permission("SortieProduitItem.list"));
        permissions.add(new Permission("SortieProduitItem.view"));
        permissions.add(new Permission("SortieProduitItem.add"));
        permissions.add(new Permission("SortieProduitItem.delete"));
        permissions.add(new Permission("Ville.edit"));
        permissions.add(new Permission("Ville.list"));
        permissions.add(new Permission("Ville.view"));
        permissions.add(new Permission("Ville.add"));
        permissions.add(new Permission("Ville.delete"));
        permissions.add(new Permission("InventaireItem.edit"));
        permissions.add(new Permission("InventaireItem.list"));
        permissions.add(new Permission("InventaireItem.view"));
        permissions.add(new Permission("InventaireItem.add"));
        permissions.add(new Permission("InventaireItem.delete"));
        permissions.add(new Permission("PaiementVente.edit"));
        permissions.add(new Permission("PaiementVente.list"));
        permissions.add(new Permission("PaiementVente.view"));
        permissions.add(new Permission("PaiementVente.add"));
        permissions.add(new Permission("PaiementVente.delete"));
        permissions.add(new Permission("Produit.edit"));
        permissions.add(new Permission("Produit.list"));
        permissions.add(new Permission("Produit.view"));
        permissions.add(new Permission("Produit.add"));
        permissions.add(new Permission("Produit.delete"));
        permissions.add(new Permission("VenteItem.edit"));
        permissions.add(new Permission("VenteItem.list"));
        permissions.add(new Permission("VenteItem.view"));
        permissions.add(new Permission("VenteItem.add"));
        permissions.add(new Permission("VenteItem.delete"));
        permissions.add(new Permission("TypeTransaction.edit"));
        permissions.add(new Permission("TypeTransaction.list"));
        permissions.add(new Permission("TypeTransaction.view"));
        permissions.add(new Permission("TypeTransaction.add"));
        permissions.add(new Permission("TypeTransaction.delete"));
        permissions.add(new Permission("UniteMesure.edit"));
        permissions.add(new Permission("UniteMesure.list"));
        permissions.add(new Permission("UniteMesure.view"));
        permissions.add(new Permission("UniteMesure.add"));
        permissions.add(new Permission("UniteMesure.delete"));
        permissions.add(new Permission("TauxTva.edit"));
        permissions.add(new Permission("TauxTva.list"));
        permissions.add(new Permission("TauxTva.view"));
        permissions.add(new Permission("TauxTva.add"));
        permissions.add(new Permission("TauxTva.delete"));
        permissions.add(new Permission("Compte.edit"));
        permissions.add(new Permission("Compte.list"));
        permissions.add(new Permission("Compte.view"));
        permissions.add(new Permission("Compte.add"));
        permissions.add(new Permission("Compte.delete"));
        permissions.add(new Permission("EtatCommande.edit"));
        permissions.add(new Permission("EtatCommande.list"));
        permissions.add(new Permission("EtatCommande.view"));
        permissions.add(new Permission("EtatCommande.add"));
        permissions.add(new Permission("EtatCommande.delete"));
        permissions.add(new Permission("ChequeEffet.edit"));
        permissions.add(new Permission("ChequeEffet.list"));
        permissions.add(new Permission("ChequeEffet.view"));
        permissions.add(new Permission("ChequeEffet.add"));
        permissions.add(new Permission("ChequeEffet.delete"));
        permissions.add(new Permission("Permutation.edit"));
        permissions.add(new Permission("Permutation.list"));
        permissions.add(new Permission("Permutation.view"));
        permissions.add(new Permission("Permutation.add"));
        permissions.add(new Permission("Permutation.delete"));
        permissions.add(new Permission("SortieProduit.edit"));
        permissions.add(new Permission("SortieProduit.list"));
        permissions.add(new Permission("SortieProduit.view"));
        permissions.add(new Permission("SortieProduit.add"));
        permissions.add(new Permission("SortieProduit.delete"));
        permissions.add(new Permission("AvoirAchat.edit"));
        permissions.add(new Permission("AvoirAchat.list"));
        permissions.add(new Permission("AvoirAchat.view"));
        permissions.add(new Permission("AvoirAchat.add"));
        permissions.add(new Permission("AvoirAchat.delete"));
        permissions.add(new Permission("PossedeCompte.edit"));
        permissions.add(new Permission("PossedeCompte.list"));
        permissions.add(new Permission("PossedeCompte.view"));
        permissions.add(new Permission("PossedeCompte.add"));
        permissions.add(new Permission("PossedeCompte.delete"));
        permissions.add(new Permission("Client.edit"));
        permissions.add(new Permission("Client.list"));
        permissions.add(new Permission("Client.view"));
        permissions.add(new Permission("Client.add"));
        permissions.add(new Permission("Client.delete"));
        permissions.add(new Permission("Inventaire.edit"));
        permissions.add(new Permission("Inventaire.list"));
        permissions.add(new Permission("Inventaire.view"));
        permissions.add(new Permission("Inventaire.add"));
        permissions.add(new Permission("Inventaire.delete"));
        permissions.add(new Permission("CommandeItem.edit"));
        permissions.add(new Permission("CommandeItem.list"));
        permissions.add(new Permission("CommandeItem.view"));
        permissions.add(new Permission("CommandeItem.add"));
        permissions.add(new Permission("CommandeItem.delete"));
        permissions.add(new Permission("Vente.edit"));
        permissions.add(new Permission("Vente.list"));
        permissions.add(new Permission("Vente.view"));
        permissions.add(new Permission("Vente.add"));
        permissions.add(new Permission("Vente.delete"));
        permissions.add(new Permission("Commande.edit"));
        permissions.add(new Permission("Commande.list"));
        permissions.add(new Permission("Commande.view"));
        permissions.add(new Permission("Commande.add"));
        permissions.add(new Permission("Commande.delete"));
        permissions.add(new Permission("Stock.edit"));
        permissions.add(new Permission("Stock.list"));
        permissions.add(new Permission("Stock.view"));
        permissions.add(new Permission("Stock.add"));
        permissions.add(new Permission("Stock.delete"));
        permissions.add(new Permission("PermutationItem.edit"));
        permissions.add(new Permission("PermutationItem.list"));
        permissions.add(new Permission("PermutationItem.view"));
        permissions.add(new Permission("PermutationItem.add"));
        permissions.add(new Permission("PermutationItem.delete"));
        permissions.add(new Permission("EtatAchat.edit"));
        permissions.add(new Permission("EtatAchat.list"));
        permissions.add(new Permission("EtatAchat.view"));
        permissions.add(new Permission("EtatAchat.add"));
        permissions.add(new Permission("EtatAchat.delete"));
        permissions.add(new Permission("PaiementAchat.edit"));
        permissions.add(new Permission("PaiementAchat.list"));
        permissions.add(new Permission("PaiementAchat.view"));
        permissions.add(new Permission("PaiementAchat.add"));
        permissions.add(new Permission("PaiementAchat.delete"));
        permissions.add(new Permission("EntreeProduitItem.edit"));
        permissions.add(new Permission("EntreeProduitItem.list"));
        permissions.add(new Permission("EntreeProduitItem.view"));
        permissions.add(new Permission("EntreeProduitItem.add"));
        permissions.add(new Permission("EntreeProduitItem.delete"));
        permissions.add(new Permission("Marque.edit"));
        permissions.add(new Permission("Marque.list"));
        permissions.add(new Permission("Marque.view"));
        permissions.add(new Permission("Marque.add"));
        permissions.add(new Permission("Marque.delete"));
        permissions.add(new Permission("EntrepriseSociete.edit"));
        permissions.add(new Permission("EntrepriseSociete.list"));
        permissions.add(new Permission("EntrepriseSociete.view"));
        permissions.add(new Permission("EntrepriseSociete.add"));
        permissions.add(new Permission("EntrepriseSociete.delete"));
        permissions.add(new Permission("TypeInstrument.edit"));
        permissions.add(new Permission("TypeInstrument.list"));
        permissions.add(new Permission("TypeInstrument.view"));
        permissions.add(new Permission("TypeInstrument.add"));
        permissions.add(new Permission("TypeInstrument.delete"));
        permissions.add(new Permission("EtatVente.edit"));
        permissions.add(new Permission("EtatVente.list"));
        permissions.add(new Permission("EtatVente.view"));
        permissions.add(new Permission("EtatVente.add"));
        permissions.add(new Permission("EtatVente.delete"));
        permissions.add(new Permission("Banque.edit"));
        permissions.add(new Permission("Banque.list"));
        permissions.add(new Permission("Banque.view"));
        permissions.add(new Permission("Banque.add"));
        permissions.add(new Permission("Banque.delete"));
    }

}


