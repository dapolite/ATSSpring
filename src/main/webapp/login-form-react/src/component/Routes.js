import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";
import RegisterFormCandidate from './LoginRegister/RegisterFormCandidate';
import RegsiterStart from './LoginRegister/RegisterStart';
import LoginStart from './LoginRegister/LoginStart';
import RegisterFormRecruiter from './LoginRegister/RegisterFormRecruiter';
import RegisterFormRecruiterSecondPage from './LoginRegister/RegisterFormRecruiterSecondPage';
import LoginForm from './LoginRegister/LoginForm';
import history from './history';
import ForgotPassword from './ForgotPassword/ForgotPassword';
import Calendars from './Calendars/Calendars';

import Dashboard from './Recruiter/Dashboard';
import ViewProfile from './Recruiter/ViewProfile';
import ManageCandidates from './Recruiter/ManageCandidates';
import ShortlistedCandidates from './Recruiter/ShortlistedCandidates';
import ManageJobs from './Recruiter/ManageJobs';
import PostNewJobs from './Recruiter/PostNewJobs';

import ViewCandidateProfile from './Candidate/ViewProfile'
import CandidateDashboard from './Candidate/Dashboard'
import CandidateAppliedJobs from './Candidate/AppliedJobs'
import CandidateFavourites from './Candidate/Favourites'
import CandidateJobs from './Candidate/Jobs'
import CandidateResume from './Candidate/Resume'
import CandidateSettings from './Candidate/Settings'
import CandidateInbox from './Candidate/Inbox'
import CandidateInboxdata from './Candidate/Inboxdata/Inboxdata';
import CandidateSentdata from './Candidate/Sentdata/Sentdata';
import CandidateDraftsdata from './Candidate/Draftsdata/Draftsdata';
import CandidateTrashdata from './Candidate/Trashdata/Trashdata';
import CandidateImportantdata from './Candidate/Importantdata/Importantdata';
import CandidateSpamdata from './Candidate/Spamdata/Spamdata';
import CandidateStarreddata from './Candidate/Starreddata/Starreddata';

import AdminDashboard from './Admin/Dashboard'
import CandidateList from './Admin/CandidateList'
import CandidateProfile from './Admin/CandidateProfile'
import JobList from './Admin/JobList'
import RecruiterList from './Admin/RecruiterList'
import RecruiterProfile from './Admin/RecruiterProfile'
 
export default class Routes extends Component{
    render(){
        return(
            <Router history={history}>
                <Switch>
                    <Route path="/" exact component={LoginStart} />
                    <Route path="/LoginForm" component={LoginForm} />
                    <Route path="/RegisterFormRecruiter" component={RegisterFormRecruiter} />
                    <Route path="/RegisterFormRecruiterSecondPage" component={RegisterFormRecruiterSecondPage} />
                    <Route path="/RegisterStart" component={RegsiterStart} />
                    <Route path="/ViewProfile" component={ViewProfile} />
                    <Route path="/Dashboard" component={Dashboard} />
                    <Route path="/ManageCandidates" component={ManageCandidates} />
                    <Route path="/ShortlistedCandidates" component={ShortlistedCandidates} />
                    <Route path="/ManageJobs" component={ManageJobs} />
                    <Route path="/PostNewJobs" component={PostNewJobs} />
                    <Route path="/Calendars" component={Calendars} />
                    
                    <Route path="/ViewCandidateProfile" component={ViewCandidateProfile} />
                    <Route path="/RegisterFormCandidate" component={RegisterFormCandidate} />
                    <Route path="/CandidateDashboard" component={CandidateDashboard} />
                    <Route path="/CandidateAppliedJobs" component={CandidateAppliedJobs} />
                    <Route path="/CandidateFavourites" component={CandidateFavourites} />
                    <Route path="/CandidateJobs" component={CandidateJobs} />
                    <Route path="/CandidateResume" component={CandidateResume} />
                    <Route path="/CandidateSettings" component={CandidateSettings} />
                    <Route path="/CandidateInbox" component={CandidateInbox} />
                    <Route path="/CandidateInboxdata" component={CandidateInboxdata} />
                    <Route path="/CandidateSentdata" component={CandidateSentdata} />
                    <Route path="/CandidateDraftsdata" component={CandidateDraftsdata} />
                    <Route path="/CandidateTrashdata" component={CandidateTrashdata} />
                    <Route path="/CandidateImportantdata" component={CandidateImportantdata} />
                    <Route path="/CandidateSpamdata" component={CandidateSpamdata} />
                    <Route path="/CandidateStarreddata" component={CandidateStarreddata} />

                    <Route path="/ForgotPassword" component={ForgotPassword} />

                    
                </Switch>
            </Router>
        )
    }
}