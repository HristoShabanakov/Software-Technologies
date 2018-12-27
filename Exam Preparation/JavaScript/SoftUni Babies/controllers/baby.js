const Baby = require('../models').Baby;

module.exports = {
    index: (req, res) => {
       Baby.findAll()
           .then(babies => res.render('baby/index',
               {babies:babies}))
    },

    createGet: (req, res) => {
        res.render('baby/create');
    },

    createPost: (req, res) => {
        let babyargs = req.body.baby;

        Baby
            .create(babyargs)
            .then(() => res.redirect('/'));
    },

    editGet: (req, res) => {
        let id = req.params.id;

        Baby.findById(id)
            .then(baby =>{
                res.render('baby/edit',{baby:baby})
            })
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let babyargs = req.body.baby;

        Baby.findById(id)
            .then(baby => baby.updateAttributes(babyargs)
                .then(() => res.redirect('/')));
    },

    deleteGet: (req, res) => {
        let id = req.params.id;

        Baby.findById(id)
            .then(baby =>{
                res.render('baby/delete',{baby:baby})
            })
    },

    deletePost: (req, res) => {
        let id = req.params.id;

        Baby.findById(id)
            .then(baby => baby.destroy()
                .then(() => res.redirect('/')));
    }
};