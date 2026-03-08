import axios from "axios";

const API = axios.create({
    baseURL: "http://localhost:8080"
});
export const getNoteFinale = async (etudiantId, matiereId) => API.get("/notes-finales?etudiantId=" + etudiantId + "&matiereId=" + matiereId)