### Workflow

Adopting [Git Worklow](https://nvie.com/posts/a-successful-git-branching-model/) using a strict branching model.

We want to release this application in cycles so we want to handle differed versions of the application in time.


### Prerequisites

* Unix OS

```
brew install git-flow
```

### Steps
* prepare the repository

| Branch  | Role| Description | Branch from| Merge to |
| ------------- | ------------- | ------------- | ------------- | ------------- |
| master  | release  | stores the official release history  |complemented initially with develoment branch |n/a|
| develop  | next release  | integration branch for features |
| feature/*| feature branches | related to new features | latest develop | develop|
| release/*| release branches forked from development branch | develop| master & develop |
| hotfix/*| quickly patch production releases |master| master & develop |
| support/*| support branches |


**Advatages:**
* using `master` branch
    * store the official releases of the app, tagged

* using `develop` branch
    * keep track of all development history
    * test the integration of the features

* using `feature` branch
    * each feature has its own branch usefull for backup/collaboration
    * are created from latest development and merge back in development for integration testing

* using `releases` branch
   * dedicated branch to prepare releases so team can continue work on features for next release.
   * creates well-defined phases of development (e.g. you can see the actual version in repository)
   * are merged to master and development when done and deleted

* using `hotfix` branch
    * are similar to release branches but are based from master
    * are merged to master and development (or current release branch) when done and deleted

```
$ git flow init
```

#### Features

```
# start a new feature
$ git flow feature start feature_name

# stop a new feature

$ git flow feature finish feature_name
```

#### Releases

```
# start a new release
$ git flow release start 1.0

# stop work a new release

$ git flow release finish '1.0'
```

#### Hotfixes
> these are quick packes for production releases and are based from master

```
# start a new hotfix
$ git flow hotfix start hotfix_name

# stop work a hotfix

$ git flow hotfix finish hotfix_name
```

* ad-hoc release branches from master that will help dev teams to focus on bug fixes
