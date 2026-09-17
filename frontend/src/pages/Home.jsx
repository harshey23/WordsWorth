function Home({ onCreateGame }) {
  return (
    <main className="container">
      <div className="min-vh-100 d-flex align-items-center justify-content-center">

        <div className="text-center">

          <h1 className="display-1 fw-bold">
            WordsWorth
          </h1>

          <p className="lead text-secondary mb-5">
            Think · Guess · Have Fun
          </p>

          <div className="d-grid gap-3 col-10 col-sm-8 col-md-6 mx-auto">

            <button
              className="btn btn-primary btn-lg"
              onClick={onCreateGame}
            >
              Create Game
            </button>

            <button className="btn btn-outline-primary btn-lg">
              Join Game
            </button>

            <button className="btn btn-outline-secondary btn-lg">
              Single Player
            </button>

          </div>

        </div>

      </div>
    </main>
  )
}

export default Home