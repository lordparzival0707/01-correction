import { useRef, useState } from 'react'
import './App.css'
import { getNoteFinale } from './services/NoteFinaleService'

function App() {

  // state (donnees)
  const [note, setNote] = useState(null)

  const etudiantIdRef = useRef()
  const matiereIdRef = useRef()

  // comportement

  const handleSumbit = async (e) => {
    e.preventDefault()
    const etudiantId = etudiantIdRef.current.value
    const matiereId = matiereIdRef.current.value
    const noteFinale = await getNoteFinale(etudiantId, matiereId);
    setNote(noteFinale.data)
    console.log(noteFinale.data)
  }

  // affichage (render)

  return (
    <div className='p-10'>

      <form onSubmit={handleSumbit}>
        <fieldset className="fieldset bg-base-200 border-base-300 rounded-box w-xs border p-4">
          <legend className="fieldset-legend">Note finale</legend>

          <label className="label">Etudiant ID</label>
          <input ref={etudiantIdRef} type="number" className="input" placeholder="Ex: 1" />

          <label className="label">Matiere ID</label>
          <input ref={matiereIdRef} type="number" className="input" placeholder="Ex: 1" />

          <button className="btn btn-primary mt-4">Afficher</button>
        </fieldset>
      </form>

      <div className="overflow-x-auto">
        <table className="table table-zebra">
          {/* head */}
          <thead>
            <tr>
              <th></th>
              <th>Matiere</th>
              <th>Note</th>
            </tr>
          </thead>
          <tbody>

            {note !== null && (
              <tr>
                <th>{note.matiere.id}</th>
                <td>{note.matiere.nom}</td>
                <td>{note.valeur}</td>
              </tr>
            )}

          </tbody>
        </table>
      </div>

    </div>
  );

}

export default App
