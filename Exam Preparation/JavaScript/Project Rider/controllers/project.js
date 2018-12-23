const Project = require('../models').Project;

module.exports = {
    //Check Views/Project/Index.hbs the name of foreach loop and initialize it here as empty object.
    index: (req, res) => {
        Project.findAll().then(projects =>{
            res.render("project/index", {projects: projects});
        })
    },
    createGet: (req, res) => {
       res.render("project/create");
    },
    //Check Create.hbs for object names.
    createPost: (req, res) => {
        let body =req.body.project;

            Project.create(body).then(() => {
                res.redirect("/");
        })
    },
    editGet: (req, res) => {
        let id = req.params.id;
//if strings are missing from the views : project:dataValues
        Project.findById(id).then(project =>{
            res.render("project/edit", {project: project})
        })
    },

    editPost: (req, res) => {
        let id = req.params.id;
        let body = req.body.project;

        Project.findById(id).then(project => {
            project.updateAttributes(body).then(()=>{
                res.redirect("/");
            })
        })
    },

    deleteGet: (req, res) => {
        let id = req.params.id;

        Project.findById(id).then(project =>{
            res.render("project/delete", {project: project})
        })
    },
    deletePost: (req, res) => {
        let id = req.params.id;

        Project.findById(id).then(project =>{
            project.destroy().then(() =>{
                res.redirect("/");
            })
        })
    }

};